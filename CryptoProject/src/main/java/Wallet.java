/*
The wallet is a the class that is essentially the user profile; it is the container for this entire application.
Each wallet object has funding, holdings, personal information, trade history, and goals.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

class Wallet implements Serializable {

    private ArrayList<Cryptocurrency> holdings;
    private UUID walletID;
    private String username;
    private String firstName;
    private String lastName;
    private ArrayList<Trade> trades;
    private BigDecimal totalAmountTraded;
    private BigDecimal totalUsdDeposited;
    private BigDecimal totalUsdWithdrawn;
    private BigDecimal USDBalance;

    // Parameterized constructor
    // The user will always supply a username, first name, and last name.
    Wallet(String firstName, String lastName, String username) {
        holdings = new ArrayList<>();
        walletID = UUID.randomUUID();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        trades = new ArrayList<>();
        USDBalance = new BigDecimal(0);
        totalAmountTraded = new BigDecimal(0);
        totalUsdDeposited = new BigDecimal(0);
        totalUsdWithdrawn = new BigDecimal(0);

        //add all the cryptos (zeroed out) to the wallet
        holdings.add(new Cryptocurrency("BTC", new BigDecimal(1)));
        holdings.add(new Cryptocurrency("ETH", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("XRP", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("BCH", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("EOS", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("LTC", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("ADA", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("XLM", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("NEO", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("XMR", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("DASH", new BigDecimal(0)));


    }

    // this method adds up the usd value of each cryptocurrency (current value * amount held) and returns it. it does NOT
    // include USD.
    BigDecimal getTotalHoldings() {

        BigDecimal totalValue = new BigDecimal(0);

        for (Cryptocurrency holding : holdings) {
            totalValue = totalValue.add(holding.getCurrentHoldingValue());
        }
        return totalValue;
    }

    // this method adds an amount to the usd. They can always add money, no check needed.
    boolean deposit(BigDecimal addAmount) {
        USDBalance = USDBalance.add(addAmount);
        totalUsdDeposited = totalUsdWithdrawn.add(addAmount);
        return true;
    }

    // this method checks that the user can withdraw, then if they can it does it. otherwise returns false.
    boolean withdraw(BigDecimal withdrawAmount) {
        if (USDBalance.compareTo(withdrawAmount) >= 0) {
            USDBalance = USDBalance.subtract(withdrawAmount);
            totalUsdWithdrawn = totalUsdWithdrawn.add(withdrawAmount);
            return true;
        } else {
            return false;
        }
    }

    // This method shows basic info on each trade.
    void showTrades() {
        if (getTotalAmountTraded().compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("No trades have occurred yet");
        } else {
            trades.forEach(trade -> {
                System.out.println("Trade ID: " + trade.getTradeID());
                System.out.println("Date of Trade: " + trade.getDateTime());
                System.out.println("From: " + trade.getFromSymbol());
                System.out.println("To: " + trade.getToSymbol());
                System.out.println("Amount: " + MenuTools.outputMoneyFormat(trade.getFromAmount().subtract(trade.getToAmount())));

            });
        }


    }

    boolean changePassword(String newPassword) {

        LoginInfo loginInfo = FileOperations.loadLoginInfo();
        if (loginInfo.removeUserAndPassword(username)) {
            loginInfo.addUserAndPassword(username, newPassword);
            FileOperations.saveLoginInfo(loginInfo);
            return true;
        } else {
            return false;
        }

    }

    boolean setGoal(BigDecimal goalPercentage) {

        //goal = null;
        if (goalPercentage == null) {
            System.out.println("You need to set your financial goal");
            System.out.println("Enter your financial goal");
            Scanner keyboard = new Scanner(System.in);

        } else {
            BigDecimal totalHoldings = USDBalance.add(getTotalHoldings());

            BigDecimal netProfit = totalHoldings.subtract(totalUsdDeposited);

            if (netProfit.compareTo(goalPercentage) > 0) {
                System.out.println("Your net profit is: " + MenuTools.outputMoneyFormat(netProfit));
                return true;
            } else {
                System.out.println("Your net profit is: " + MenuTools.outputMoneyFormat(netProfit));

                return netProfit.compareTo(goalPercentage) == 0;
            }
        }

        return true;

    }

    // This method shows general Wallet data.
    void showWalletData() {

        BigDecimal totalHoldings = getTotalHoldings();
        System.out.println("\nHello " + firstName + " " + lastName + "!");
        System.out.println("\nBASIC INFO:");
        System.out.println("\nWallet ID: " + walletID);
        System.out.println("Total Holdings USD Worth:  " + MenuTools.outputMoneyFormat(totalHoldings));
        System.out.println("USD Balance: " + MenuTools.outputMoneyFormat(getUSDBalance()));
        System.out.println("Total Wallet Value: " + MenuTools.outputMoneyFormat(totalHoldings.add(getUSDBalance())));
        System.out.println("Total USD Deposited: " + MenuTools.outputMoneyFormat(getTotalUsdDeposited()));
        System.out.println("Total USD Withdrawn: " + MenuTools.outputMoneyFormat(getTotalUsdWithdrawn()));
        System.out.println("Total Amount traded: " + MenuTools.outputMoneyFormat(getTotalAmountTraded()));
        System.out.println("\nTRADES: ");
        showTrades();

        MenuTools.promptEnterKey();

    }

    ArrayList<Cryptocurrency> getHoldings() {
        return holdings;
    }

    BigDecimal getUSDBalance() {
        return USDBalance;
    }

    void setUSDBalance(BigDecimal USDBalance) {
        this.USDBalance = USDBalance;
    }

    void addTrade(Trade trade) {

        trades.add(trade);
    }

    String getUsername() {
        return username;
    }

    String getFirstName() {
        return firstName;
    }

    BigDecimal getTotalUsdDeposited() {
        return totalUsdDeposited;
    }

    void setTotalUsdDeposited(BigDecimal totalUsdDeposited) {
        this.totalUsdDeposited = totalUsdDeposited;
    }

    BigDecimal getTotalUsdWithdrawn() {
        return totalUsdWithdrawn;
    }

    void setTotalUsdWithdrawn(BigDecimal totalUsdWithdrawn) {
        this.totalUsdWithdrawn = totalUsdWithdrawn;
    }

    BigDecimal getTotalAmountTraded() {
        return totalAmountTraded;
    }

    void setTotalAmountTraded(BigDecimal totalAmountTraded) {
        this.totalAmountTraded = totalAmountTraded;
    }
}

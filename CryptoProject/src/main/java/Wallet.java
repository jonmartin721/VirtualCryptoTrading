/*
The wallet is a the class that is essentially the user profile; it is the container for this entire application.
Each wallet object has funding, holdings, personal information, trade history, and goals.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Wallet implements Serializable {

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
        holdings.add(new Cryptocurrency("BTC", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("ETH", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("XRP", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("DASH", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("BCH", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("XLM", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("LTC", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("EOS", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("ADA", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("XMR", new BigDecimal(0)));
        holdings.add(new Cryptocurrency("NEO", new BigDecimal(0)));


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
        if (getTotalAmountTraded() == null) {
            System.out.println("No trades have occurred yet");
        } else {
            trades.forEach(trade -> {
                System.out.println("Trade ID: " + String.valueOf(trade.getTradeID()));
                MenuTools.lineDivider();
                System.out.println("Date of Trade: " + String.valueOf(trade.getDateTime()));
                MenuTools.lineDivider();
                System.out.println("From: " + String.valueOf(trade.getFromSymbol()));
                MenuTools.lineDivider();
                System.out.println("To: " + String.valueOf(trade.getToSymbol()));
                MenuTools.lineDivider();
                System.out.println("Amount: " + String.valueOf(trade.getFromAmount().subtract(trade.getToAmount())));

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

    //TODO test to see if setGoal works
    //TODO add a companion method checkGoal to check progress
    //TODO use return method of this method where it is used
    boolean setGoal(BigDecimal goalPercentage) {

        //goal = null;
        if (goalPercentage == null) {
            System.out.println("You need to set your financial goal");
            System.out.println("Enter your financial goal");
            Scanner keyboard = new Scanner(System.in);

        } else {
            BigDecimal totalHoldings = USDBalance.add(getTotalHoldings());

            BigDecimal netProfit = totalHoldings.subtract(totalUsdDeposited);

            //TODO does this need to be here? always true?

                if (netProfit.compareTo(goalPercentage) > 0) {
                    System.out.println("Your net profit is: " + MenuTools.outputMoneyFormat(netProfit));
                    return true;
                }

                else {
                    System.out.println("Your net profit is: " + MenuTools.outputMoneyFormat(netProfit));

                    return netProfit.compareTo(goalPercentage) == 0;
                }
        }

        return true;

    }

    // This class shows general Wallet data.
    void showWalletData() {

        System.out.println();
        System.out.println("Hello " + firstName + " " + lastName);
        MenuTools.lineDivider();
        System.out.println("Wallet ID: " + walletID);
        MenuTools.lineDivider();
        System.out.println("Balance: " + MenuTools.outputMoneyFormat(getUSDBalance()));
        MenuTools.lineDivider();
        System.out.println("Total USD Deposited: " + MenuTools.outputMoneyFormat(getTotalUsdDeposited()));
        MenuTools.lineDivider();
        System.out.println("Total USD Withdrawn: " + MenuTools.outputMoneyFormat(getTotalUsdWithdrawn()));
        MenuTools.lineDivider();
        System.out.println("Total amount traded: " + MenuTools.outputMoneyFormat(getTotalAmountTraded()));
        MenuTools.lineDivider();
        System.out.println("You have traded in the following: ");
        MenuTools.lineDivider();
        showTrades();
        MenuTools.lineDivider();
        System.out.println("Your total holdings are:  " + MenuTools.outputMoneyFormat(getTotalHoldings()));
        MenuTools.lineDivider();
        MenuTools.promptEnterKey();

    }

    ArrayList<Cryptocurrency> getHoldings() {
        return holdings;
    }

    public void setHoldings(ArrayList<Cryptocurrency> holdings) {
        this.holdings = holdings;
    }

    BigDecimal getUSDBalance() {
        return USDBalance;
    }

    public UUID getWalletID() {
        return walletID;
    }

    void setUSDBalance(BigDecimal USDBalance) {
        this.USDBalance = USDBalance;
    }

    boolean addTrade(Trade trade) {

        trades.add(trade);
        return true;
    }


    String getUsername() {
        return username;
    }

    String getFirstName() {
        return firstName;
    }

    private BigDecimal getTotalUsdDeposited() {
        return totalUsdDeposited;
    }

    public void setTotalUsdDeposited(BigDecimal totalUsdDeposited) {
        this.totalUsdDeposited = totalUsdDeposited;
    }

    private BigDecimal getTotalUsdWithdrawn() {
        return totalUsdWithdrawn;
    }

    public void setTotalUsdWithdrawn(BigDecimal totalUsdWithdrawn) {
        this.totalUsdWithdrawn = totalUsdWithdrawn;
    }

    private BigDecimal getTotalAmountTraded() {
        return totalAmountTraded;
    }

    public void setTotalAmountTraded(BigDecimal totalAmountTraded) {
        this.totalAmountTraded = totalAmountTraded;
    }
}

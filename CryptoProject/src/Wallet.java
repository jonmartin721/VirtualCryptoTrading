/*
The wallet is a the class that is essentially the user profile; it is the container for this entire application.
Each wallet object has funding, holdings, personal information, trade history, and goals.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

public class Wallet implements Serializable {

    private ArrayList<Cryptocurrency> holdings;
    private UUID walletID;
    private String username;
    private EncryptionService encryption;
    private String firstName;
    private String lastName;
    private ArrayList<Trade> trades;
    private byte[] password;
    private BigDecimal totalAmountTraded;
    private BigDecimal totalUSDdeposited;
    private BigDecimal totalUSDwithdrawn;
    private BigDecimal USDBalance;

    // Parameterized constructor
    // The user will always supply a username, first name, and last name.
    Wallet(String firstName, String lastName, String username) {
        holdings = new ArrayList<>();
        walletID = UUID.randomUUID();
        this.username = username;
        encryption = new EncryptionService();
        this.firstName = firstName;
        this.lastName = lastName;
        trades = new ArrayList<>();
        password = new byte[0];
        USDBalance = new BigDecimal(0);
        totalAmountTraded = new BigDecimal(0);
        totalUSDdeposited = new BigDecimal(0);
        totalUSDwithdrawn = new BigDecimal(0);

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
        totalUSDdeposited = totalUSDwithdrawn.add(addAmount);
        return true;
    }

    // this method checks that the user can withdraw, then if they can it does it. otherwise returns false.
    boolean withdraw(BigDecimal withdrawAmount) {
        if (USDBalance.compareTo(withdrawAmount) >= 0) {
            USDBalance = USDBalance.subtract(withdrawAmount);
            totalUSDwithdrawn = totalUSDwithdrawn.add(withdrawAmount);
            return true;
        } else {
            return false;
        }
    }

    // This method shows basic info on each trade.
    void showTrades() {
        if (getTotalAmountTraded() == null){
            System.out.println("No trades have occurred yet");
        }

        else {
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

    // TODO Set password in Wallet using this
    public boolean setPassword(EncryptionService object) {
        // this.password = new byte[object.getEncryptedAttemptedPassword()]; ??
        // return true;
        // return false;
        // Jon - leave this to me. I'll be helping.
        return true;

    }

    //TODO Change password (no confirmation required)
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
        // This class will add up all the holdings into USD and then display true when the netProfit is higher than the
        // goal, or equal to the goal


        // The user needs to specify what the goal they want to reach is. The program asks for user input. I'm not
        // sure where to ask for the user input, so I'm putting it here for review. For now, I have set the goal to null.

       /* Scanner scan=   new Scanner(System.in);
        System.out.println(" Enter your goal: ");
        goal= scan.nextBigDecimal();*/

       // Amee- goal is met when original holdings - withdrawals + the amount in $$ that represent the goalPercentage equals
        // goalPercentage!


        //goal = null;
        if (goalPercentage == null){
            System.out.println("You need to set your financial goal");
            System.out.println("Enter your financial goal");
            Scanner keyboardSG = new Scanner(System.in);
            BigDecimal newGoalPercentage = keyboardSG.nextBigDecimal();
            goalPercentage = newGoalPercentage;
        }
        else {
            BigDecimal totalHoldings = USDBalance.add(getTotalHoldings());

            BigDecimal netProfit = totalHoldings.subtract(totalUSDdeposited);

            if (goalPercentage != null) {
                if (netProfit.compareTo(goalPercentage) > 0) {
                    System.out.println("Your net profit is: " + MenuTools.outputMoneyFormat(netProfit));
                    return true;
                }

            } else {
                System.out.println("Your net profit is: " + MenuTools.outputMoneyFormat(netProfit));
                return netProfit.compareTo(goalPercentage) == 0;
            }
        }

        return true;

    }

    // This class shows general Wallet data.
    public void showWalletData() {

        System.out.println();
        System.out.println("Hello " + firstName + " " + lastName);
        MenuTools.lineDoubleDivider();
        System.out.println("Wallet ID: " + walletID);
        MenuTools.lineDivider();
        System.out.println("Balance: " + MenuTools.outputMoneyFormat(getUSDBalance()));
        MenuTools.lineDivider();
        System.out.println("Total USD Deposited: " + MenuTools.outputMoneyFormat(getTotalUSDdeposited()));
        MenuTools.lineDivider();
        System.out.println("Total USD Withdrawn: " + MenuTools.outputMoneyFormat(getTotalUSDwithdrawn()));
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
        return new ArrayList<>();
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

    String getUsername() {
        return username;
    }

    String getFirstName() {
        return firstName;
    }

    public BigDecimal getTotalUSDdeposited() {
        return totalUSDdeposited;
    }

    public void setTotalUSDdeposited(BigDecimal totalUSDdeposited) {
        this.totalUSDdeposited = totalUSDdeposited;
    }

    public BigDecimal getTotalUSDwithdrawn() {
        return totalUSDwithdrawn;
    }

    public void setTotalUSDwithdrawn(BigDecimal totalUSDwithdrawn) {
        this.totalUSDwithdrawn = totalUSDwithdrawn;
    }

    public BigDecimal getTotalAmountTraded() {
        return totalAmountTraded;
    }

    public void setTotalAmountTraded(BigDecimal totalAmountTraded) {
        this.totalAmountTraded = totalAmountTraded;
    }
}

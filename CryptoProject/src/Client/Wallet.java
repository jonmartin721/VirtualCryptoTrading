package Client;

/*
The wallet is a the class that is essentially the user profile; it is the container for this entire application.
Each wallet object has funding, holdings, personal information, trade history, and goals.
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class Wallet {

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

    //the user will always supply a username, first name, and last name
    public Wallet(String firstName, String lastName, String username) {
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
    public BigDecimal getTotalHoldings() {

        BigDecimal totalValue = new BigDecimal(0);

        for (Cryptocurrency holding : holdings) {
            totalValue = totalValue.add(holding.getCurrentHoldingValue());
        }
        return totalValue;
    }

    // this method adds an amount to the usd. They can always add money.
    public boolean deposit(BigDecimal addAmount) {
        USDBalance = USDBalance.add(addAmount);
        return true;
    }

    // this method checks that the user can withdraw, then if they can it does it. otherwise returns false.
    public boolean withdraw(BigDecimal withdrawAmount) {
        if (USDBalance.compareTo(withdrawAmount) >= 0) {
            USDBalance = USDBalance.subtract(withdrawAmount);
            return true;
        } else {
            return false;
        }
    }

    public void showTrades() {

        //TODO BG - Write code here to System.out.println() the variables that make up each trade. Use a loop.
        trades.forEach(trade->{
            System.out.println("Trade ID: " + String.valueOf(trade.getTradeID()));
            System.out.println("Date of Trade: " + String.valueOf(trade.getDateTime()));
            System.out.println("From: " + String.valueOf(trade.getFromSymbol()));
            System.out.println("To: " + String.valueOf(trade.getToSymbol()));
            System.out.println("Amount: " + String.valueOf(trade.getFromAmount().subtract(trade.getToAmount())));

        });


    }

    public boolean setPassword(EncryptionService object) {
        // this.password = new byte[object.getEncryptedAttemptedPassword()]; ??
        // return true;
        // return false;
        // Jon - leave this to me. I'll be helping.
        return true;

    }

    public boolean changePassword() {
        // ASSUMING THIS WILL CONNECT WITH PasswordEncryptionService class?
        // COME BACK TO THIS
        // Jon - this calls its own object of the PasswordEncryptionService. This will simply ask for and set a new pass.

        return true;
    }

    public boolean setGoal(BigDecimal goal) {
        // NEED TO DEFINE WHAT THE GOAL IS
        // IS IT MONETARY, IT IS A PERCENTAGE OF MONETARY
        // WHAT IS THE CONDITIONAL AMOUNT?
        // Jon - Let's add up the USD value of all of their holdings sometimes. Compare that to the amount they put in, in USD,
        // and you have a net profit amount. They can set 200, and if they invest 200 and have 400, their goal would have
        // been met. You can add more variables if you need in order to track this.
        return true;
    }


    public void showWalletData() {
        // CONFIRM void IS THE RETURN TYPE
        // LOTS OF System.out.println() STATEMENTS HERE?
        // WHAT WALLET DATA CONTENTS EXACTLY?
        // Jon - any method that outputs to sout doesn't need a return type: we can see if it is successful without
        // needing boolean. It's kind of up to you what you want to display, I recommend using almost every bit of data
        // and outputting it in some way with pretty tables.
    }

    // **I'M GOING TO LEAVE THESE IN HERE TEMPORARILY UNTIL IMPLEMENTATION IS FIRM**
    public ArrayList<Cryptocurrency> getHoldings() {
        return new ArrayList<>();
    }

    public void setHoldings(ArrayList<Cryptocurrency> holdings) {
        this.holdings = holdings;
    }

    public BigDecimal getUSDBalance() {
        return USDBalance;
    }

    public void setUSDBalance(BigDecimal USDBalance) {
        this.USDBalance = USDBalance;
    }

    public UUID getWalletID() {
        return walletID;
    }

    public void setWalletID(UUID walletID) {
        this.walletID = walletID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

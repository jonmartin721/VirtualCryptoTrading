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
    private BigDecimal usdBalance;
    private UUID walletID;
    private String username;
    private EncryptionService encryption;
    private String firstName;
    private String lastName;
    private ArrayList<Trade> trades;
    private byte[] password;
    private BigDecimal totalAmountTraded;
    private BigDecimal traded24Hours;


    public Wallet() {
        holdings = new ArrayList<>();  // I'M UNSURE WHAT TO INITIALISE Jon - an empty list of cryptos
        usdBalance = new BigDecimal(0);
        walletID = UUID.randomUUID();
        username = "";
        encryption = new EncryptionService();
        firstName = "";
        lastName = "";
        trades = new ArrayList<>();    // I'M UNSURE WHAT TO INITIALISE Jon- an empty list of trades just like that
        password = new byte[0];
        totalAmountTraded = new BigDecimal("");
        traded24Hours = new BigDecimal("");


    }

    public BigDecimal getTotalValue(){
        // QUESTION: getTotalValue of totalAmountTraded or
        // what was traded24Hours??
        // Jon - this goes through their holdings one by one, converts to USD, and adds them all together, returning
        // essentially the total worth of their wallet. This will not include their USD balance.
        return totalAmountTraded;
    }

    public boolean addAmount(BigDecimal initialAmount){
        usdBalance = usdBalance.add(initialAmount);
        //return usdBalance.compareTo(usdBalance) < 0; //You're comparing the exact same variable to itself.
        return true;
    }

    public ArrayList<Trade> showTrades() {
        //ArrayList<Trade> var = getTrades();
        // return var;
        // BUT IF IT'S showTrades(), then should I use a
        // System.out.println(var); ?

        return new ArrayList<>();
    }

    public boolean setPassword(EncryptionService object){
        // this.password = new byte[object.getEncryptedAttemptedPassword()]; ??
        // return true;
        // return false;
        // Jon - leave this to me. I'll be helping.
        return true;

    }

    public boolean changePassword(){
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

    public BigDecimal getUsdBalance() {
        return usdBalance;
    }

    public void setUsdBalance(BigDecimal usdBalance) {
        this.usdBalance = usdBalance;
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

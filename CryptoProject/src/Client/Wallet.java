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
    //private BigDecimal initialAmount;


    public Wallet() {
        holdings = new ArrayList<Cryptocurrency>();  // I'M UNSURE WHAT TO INITIALISE
        usdBalance =  new BigDecimal("");
        walletID = UUID.randomUUID();
        username = "";
        encryption = new EncryptionService();
        firstName = "";
        lastName = "";
        trades = new ArrayList<Trade>();    // I'M UNSURE WHAT TO INITIALISE
        password = new byte[0];
        totalAmountTraded = new BigDecimal("");
        traded24Hours = new BigDecimal("");


    }

    public BigDecimal getTotalValue(){
        // QUESTION: getTotalValue of totalAmountTraded or
        // what was traded24Hours??
        return totalAmountTraded;
    }

    public boolean addAmount(BigDecimal initialAmount){
        usdBalance = usdBalance.add(initialAmount);
        return usdBalance.compareTo(usdBalance) < 0;
    }

    public ArrayList<Trade> showTrades() {
        //ArrayList<Trade> var = getTrades();
        // return var;
        // BUT IF IT'S showTrades(), then should I use a
        // System.out.println(var); ?
    }

    public boolean setPassword(EncryptionService object){
        // this.password = new byte[object.getEncryptedAttemptedPassword()]; ??
        // return true;
        // return false;

    }

    public boolean changePassword(){
        // ASSUMING THIS WILL CONNECT WITH PasswordEncryptionService class?
        // COME BACK TO THIS
    }

    public boolean setGoal(){
        // NEED TO DEFINE WHAT THE GOAL IS
        // IS IT MONETARY, IT IS A PERCENTAGE OF MONETARY
        // WHAT IS THE CONDITIONAL AMOUNT?
    }

    public void shotWalletData(){
        // CONFIRM void IS THE RETURN TYPE
        // LOTS OF System.out.println() STATEMENTS HERE?
        // WHAT WALLET DATA CONTENTS EXACTLY?
    }

    // **I'M GOING TO LEAVE THESE IN HERE TEMPORARILY UNTIL IMPLEMENTATION IS FIRM**
    public ArrayList<Cryptocurrency> getHoldings() {
        return holdings;
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

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
    private BigDecimal traded24Hours;


    public Wallet() {
        holdings = new ArrayList<Cryptocurrency>();
        usdBalance =  new BigDecimal(0);
        walletID = UUID.randomUUID();
        username = "";
        encryption = new EncryptionService();
        firstName = "";
        lastName = "";
        trades = new ArrayList<Trade>();
        password = new byte[0];
        traded24Hours = new BigDecimal(0);


    }
// *** STOPPED HERE @ 12:43PM 3/25 ***
    public double getTotalValue(){
        // I'M NOT SURE HOW getTotalValue calculates yet.
        return 0.0;
    }

    public void setPassword(){
        // ASSUMING THIS WILL CONNECT WITH PasswordEncryptionService class?
    }

    public void changePassword(){
        // ASSUMING THIS WILL CONNECT WITH PasswordEncryptionService class?
    }

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

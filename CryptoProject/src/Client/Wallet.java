package Client;

import java.util.ArrayList;
import java.util.UUID;

public class Wallet {

    ArrayList<Cryptocurrency> holdings;
    double usdBalance;
    UUID walletID;
    String username;

    Wallet(){
        holdings = new ArrayList<Cryptocurrency>();
        usdBalance = 0.0;
        username = "";
        walletID = UUID.randomUUID();
    }

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

    public double getUsdBalance() {
        return usdBalance;
    }

    public void setUsdBalance(double usdBalance) {
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

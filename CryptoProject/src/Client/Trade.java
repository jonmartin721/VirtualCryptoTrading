package Client;

/*
This class holds trade objects, these are stored in each Wallet object and represent a history of trades performed
in that Wallet (account).
 */

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Trade {

    private UUID tradeID;
    private LocalDateTime dateTime;
    private BigDecimal fromAmount;
    private BigDecimal toAmount;
    private String fromSymbol;
    private String toSymbol;

    // There will be no default constructor, because we won't be consistently creating the same type of object.
    // Remember, there are 3 types of trades:

    // 1) Crypto to Crypto
    // 2) USD to Crypto
    // 3) Crypto to USD
    // Each of these types is represented below in a method and each will create its own unique TradingPair and it will be added to the list

    // PARAMETERIZED CONSTRUCTOR
    // This can be used for any of the 3 types.
    Trade(BigDecimal fromAmount, BigDecimal toAmount, String fromSymbol, String toSymbol) {

        tradeID = UUID.randomUUID();
        dateTime = LocalDateTime.now();
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.fromSymbol = fromSymbol;
        this.toSymbol = toSymbol;

    }


    // METHODS
    public boolean tradeCryptoToUSD(Cryptocurrency fromCrypto, Currency toUSD, Wallet wallet) {

        return true;
    }

    public boolean tradeUSDToCrypto(Currency fromUSD, Cryptocurrency toCrypto, Wallet wallet) {
        // CONVERTING FROM USD TO CRYPTO AND ADDING THAT AMOUNT TO MY WALLET OF TYPE WALLET

        return true;
    }

    public boolean tradeCryptoToCrypto(Cryptocurrency fromCrypto, Cryptocurrency toCrypto, Wallet wallet) {

        return true;
    }

    // This method checks that Crypto - > Crypto trades are possible
    public boolean checkTradeCryptoToCrypto(Wallet wallet, Cryptocurrency fromCrypto, Cryptocurrency toCrypto) {

        return true;

    }

    // This method checks that Crypto - > Crypto trades are possible
    public boolean checkTradeCryptoToUSD(Wallet wallet, Cryptocurrency fromCrypto, BigDecimal toUSD) {

        return true;
    }

    // This method checks that Crypto - > Crypto trades are possible
    public boolean checkTradeUSDToCrypto(Wallet wallet, BigDecimal fromUSD, Cryptocurrency toCrypto) {

        return true;
    }

    // This method will output trade data
    public void showTradeData() {
        // CONFIRM WHAT System.out.println() JON WANTS TO SHOW.
        // SHOW ALL INSTANCE VARIABLES COMPRISES tradeData?
        // Jon - That's correct, use this to simply output all useful variables.
    }

    // SETTERS AND GETTERS
    public UUID getTradeID() {
        return tradeID;
    }

    public void setTradeID(UUID tradeID) {
        this.tradeID = tradeID;
    }

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }

    public String getFromSymbol() {
        return fromSymbol;
    }

    public void setFromSymbol(String fromSymbol) {
        this.fromSymbol = fromSymbol;
    }

    public String getToSymbol() {
        return toSymbol;
    }

    public void setToSymbol(String toSymbol) {
        this.toSymbol = toSymbol;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}


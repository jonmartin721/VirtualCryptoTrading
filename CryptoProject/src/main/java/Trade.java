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

    public boolean tradeCryptoToCrypto(Cryptocurrency fromCrypto, Cryptocurrency toCrypto, Wallet wallet) {

        //perform trade
//remove left crypto and gain right crypto
//
//return that trade failed
        return checkTradeCryptoToCrypto(wallet, fromCrypto, toCrypto);
    }

    public boolean tradeCryptoToUSD(Cryptocurrency fromCrypto, Money toUSD, Wallet wallet) {


        if (checkTradeCryptoToUSD(wallet, fromCrypto, toAmount) == true) {

            //lose left side value. gain right side value.
            // calculation is done on server side.
            wallet.deposit(toAmount);

            return false;
        } else {
            return true;
        }

    }

    public boolean tradeUSDToCrypto(Money fromUSD, Cryptocurrency toCrypto, Wallet wallet) {

        if (checkTradeUSDToCrypto(wallet, fromAmount, toCrypto) == true) {
            //calculation is done in server side
            //left side loses, right side gains
            // update wallet

            wallet.withdraw(fromAmount);
            return true;
        } else {
            return false;
        }


    }

    // This method checks that Crypto - > Crypto trades are possible
    private boolean checkTradeCryptoToCrypto(Wallet wallet, Cryptocurrency fromCrypto, Cryptocurrency toCrypto) {
//            if (fromCrypto.getAmountHeld().equals(toCrypto.getCurrentCryptoValue()))//checks if the amount being traded is valid
//            {
//                {
//                    return true;
//                }
//          }
//                else
//                return false;
        return !(fromCrypto.equals(toCrypto));
    }

    // This method checks that Crypto - > Crypto trades are possible
    private boolean checkTradeCryptoToUSD(Wallet wallet, Cryptocurrency fromCrypto, BigDecimal toUSD) {
        return (fromCrypto.getCurrentHoldingValue().compareTo(toUSD) > 0) || (fromCrypto.getCurrentHoldingValue().compareTo(toUSD) == 0);

    }

    // This method checks that Crypto - > Crypto trades are possible
    private boolean checkTradeUSDToCrypto(Wallet wallet, BigDecimal fromUSD, Cryptocurrency toCrypto) {

        return (toCrypto.getCurrentHoldingValue().compareTo(fromUSD) < 0) || (toCrypto.getCurrentHoldingValue().compareTo(fromUSD) == 0);
    }

    // SETTERS AND GETTERS
    UUID getTradeID() {
        return tradeID;
    }

    public void setTradeID(UUID tradeID) {
        this.tradeID = tradeID;
    }

    BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }

    String getFromSymbol() {
        return fromSymbol;
    }

    public void setFromSymbol(String fromSymbol) {
        this.fromSymbol = fromSymbol;
    }

    String getToSymbol() {
        return toSymbol;
    }

    public void setToSymbol(String toSymbol) {
        this.toSymbol = toSymbol;
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}


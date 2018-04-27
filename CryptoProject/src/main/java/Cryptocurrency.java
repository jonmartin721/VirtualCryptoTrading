/*
This class is instantiated and put in every Wallet as a cryptocurrency held by that user. It contains all the info needed
on each cryptocurrency.
 */

import POJOs.SingleValue;
import Service.APICalls;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;

class Cryptocurrency extends Money implements Serializable {

    private String symbol;

    Cryptocurrency(String symbol, BigDecimal amountHeld) {
        this.symbol = symbol;
        this.amountHeld = amountHeld;
    }

    // Returns from the API what the current value of this crypto is
    BigDecimal getCurrentCryptoValue() {

        //returns 0 immediately if they don't have any (will save lots of time)
        if (amountHeld.compareTo(BigDecimal.ZERO) == 0) {
            return new BigDecimal(0);
        }

        try {
            SingleValue singleValue = APICalls.getSingleValue(symbol);
            return new BigDecimal(singleValue.getValue());
        } catch (IOException e) {
            e.printStackTrace();
            return new BigDecimal(0);
        }

    }

    // Multiplies current crypto value by amountHeld and returns the value in USD of this holding
    BigDecimal getCurrentHoldingValue() {

        BigDecimal holdingValue;
        holdingValue = this.getCurrentCryptoValue();
        holdingValue = holdingValue.multiply(getAmountHeld());
        return holdingValue;

    }

    BigDecimal getAmountHeld() {

        return amountHeld;
    }

    void setAmountHeld(BigDecimal amountHeld) {
        this.amountHeld = amountHeld;
    }


    String getSymbol() {
        return symbol;
    }
}

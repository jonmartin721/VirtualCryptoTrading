import jdk.jfr.Percentage;

import java.math.BigDecimal;
import java.util.UUID;


public class Cryptocurrency {


    private String tag;
    private UUID cryptoID;
    private String name;
    private BigDecimal currentValue;
    private BigDecimal amountHeld;
    private Percentage last4Hours;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    private UUID getCryptoID() {
        return cryptoID;// Unique identifier
    }

    public void setCryptoID(UUID cryptoID) {
        this.cryptoID = cryptoID;
    }

    public String getName() {
        return name;// gets the names of the three CryptoCurrencies
    }

    public void setName(String name) {
        this.name = name;// returns the names of the CrytoCurrencies
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    public BigDecimal getAmountHeld() {
        return amountHeld;
    }

    public void setAmountHeld(BigDecimal amountHeld) {
        this.amountHeld = amountHeld;
    }

    public Percentage getLast4Hours() {
        return last4Hours;
    }

    public void setLast4Hours(Percentage last4Hours) {
        this.last4Hours = last4Hours;
    }







}
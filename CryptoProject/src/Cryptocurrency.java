/*
This class is instantiated and put in every Wallet as a cryptocurrency held by that user. It contains all the info needed
on each cryptocurrency.
 */

import jdk.jfr.Percentage;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinbase.v2.CoinbaseExchange;
import org.knowm.xchange.coinbase.v2.dto.CoinbasePrice;
import org.knowm.xchange.coinbase.v2.service.CoinbaseMarketDataService;
import org.knowm.xchange.currency.Currency;

import java.io.IOException;
import java.math.BigDecimal;

class Cryptocurrency extends Money {


    private String symbol;
    private BigDecimal currentValue;
    private Percentage last4Hours;

    // Returns from the API what the current value of this crypto is
    private BigDecimal getCurrentCryptoValue() {

        //create API stuff
        //TODO make API an interface or class to improve modularity
        Currency thisCurrency = new Currency(symbol);
        Exchange coinbaseExchange =
                ExchangeFactory.INSTANCE.createExchange(CoinbaseExchange.class.getName());
        CoinbaseMarketDataService marketDataService =
                (CoinbaseMarketDataService) coinbaseExchange.getMarketDataService();
        try {
            CoinbasePrice spotRate = marketDataService.getCoinbaseSpotRate(thisCurrency, Currency.USD);
            return new BigDecimal(String.valueOf(spotRate));
        } catch (IOException e) {
            MenuTools.networkException();
            return new BigDecimal(0);
        }

    }

    // Multiplies current crypto value by amountHeld and returns the value in USD of this holding
    BigDecimal getCurrentHoldingValue() {

        BigDecimal holdingValue;
        holdingValue = this.getCurrentCryptoValue();
        holdingValue = holdingValue.multiply(BigDecimal.valueOf(getAmountHeld()));
        return holdingValue;

    }

    private Double getAmountHeld() {

        return amountHeld;
    }

    public void setAmountHeld(Double amountHeld) {
        this.amountHeld = amountHeld;
    }

}

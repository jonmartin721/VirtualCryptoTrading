package Client;

/*
This class holds trade objects, these are stored in each Wallet object and represent a history of trades performed
in that Wallet (account).
 */

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Trade {

    private UUID tradeID;
    private Date tradeDate;
    // private Time tradeTime;  // CONFIRM WITH JON THE IMPORT LIBRARY ON THIS ONE
    private LocalTime tradeTime;
    private BigDecimal tradeAmount;
    private ArrayList<Cryptocurrency, Cryptocurrency> tradingPair; // NEED TO CLARIFY THIS INSTANCE VARIABLE OF THIS TYPE

    Trade() {
        tradeID = UUID.randomUUID();
        tradeDate = new Date();
        tradeTime = LocalTime.now(); // CONFIRM THIS IS WHAT JON WANTS
        tradeAmount = new BigDecimal("");
        tradingPair = // STILL WORKING ON THIS ONE
    }

    public boolean tradeToUSD(Cryptocurrency fromCrypto, Currency toUSD, Wallet wallet){
        // CONFIRM WITH JON WHAT I'M PERFORMING HERE
        // CONVERTING CRYPTO TO USD AND ADDING THAT AMOUNT TO MY WALLET OF TYPE WALLET
    }

    public boolean tradeFromUSD(Currency fromUSD, Cryptocurrency toCrypto, Wallet wallet){
        // CONVERTING FROM USD TO CRYPTO AND ADDING THAT AMOUNT TO MY WALLET OF TYPE WALLET
    }

    public boolean tradeCryptoToCrypto(Cryptocurrency fromCrypto, Cryptocurrency toCrypto, Wallet wallet){

    }

    public boolean checkTrade(BigDecimal value, Wallet wallet){

    }

    public void showTradeData(){
        // CONFIRM WHAT System.out.println() JON WANTS TO SHOW.
        // SHOW ALL INSTANCE VARIABLES COMPRISES tradeData?
    }

}

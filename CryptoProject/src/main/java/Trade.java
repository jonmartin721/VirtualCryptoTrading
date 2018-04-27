/*
This class holds trade objects, these are stored in each Wallet object and represent a history of trades performed
in that Wallet (account).
 */

import Service.APICalls;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Trade implements Serializable {

    private UUID tradeID;
    private LocalDateTime dateTime;
    private BigDecimal fromAmount;
    private BigDecimal toAmount;
    private String fromSymbol;
    private String toSymbol;


    //trade constructor
    private Trade(String fromSymbol, String toSymbol, BigDecimal fromAmount, BigDecimal toAmount) {

        this.fromSymbol = fromSymbol;
        this.toSymbol = toSymbol;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.tradeID = UUID.randomUUID();
        this.dateTime = LocalDateTime.now();

    }


    static boolean tradeCryptoToUSD(int cryptoPosition, Wallet wallet) {

        try {

            String cryptoSymbol = wallet.getHoldings().get(cryptoPosition).getSymbol();
            double currentValueDouble = APICalls.getSingleValue(cryptoSymbol).getValue();
            BigDecimal currentValue = new BigDecimal(currentValueDouble);
            System.out.println("\nSelling " + cryptoSymbol + ":");
            System.out.println("USD Value: " + MenuTools.outputMoneyFormat(currentValueDouble));

            //ask the user how much they want to sell
            System.out.println("How much (of amount held) to sell?");
            Scanner keyboard = new Scanner(System.in);
            double proposedAmountToSell = keyboard.nextDouble();
            while (proposedAmountToSell < 0) {
                System.out.println("Invalid amount, choose a valid amount.");
                proposedAmountToSell = keyboard.nextDouble();
            }

            //if the trade is valid, perform the trade
            //1. remove the amount held from the crypto
            //2. add the USD balance to balance
            //3. add trade record to trades in wallet

            if (checkTradeCryptoToUSD(wallet, proposedAmountToSell, cryptoPosition)) {
                //get the total amount held of the crypto
                BigDecimal amountHeld = wallet.getHoldings().get(cryptoPosition).getAmountHeld();
                //get usd held
                BigDecimal usdHeld = wallet.getUSDBalance();


                //calculate USD value of proposed amount to sell
                BigDecimal proposedAmountBigDecimal = new BigDecimal(proposedAmountToSell);
                BigDecimal proposedSellValue = currentValue.multiply(proposedAmountBigDecimal);

                //check with the user and display trade data
                System.out.println("\n###############");
                System.out.println("Proposed Trade");
                System.out.println("###############");
                System.out.println(wallet.getHoldings().get(cryptoPosition).getSymbol() + ":" + "\nFrom: " + MenuTools.outputSixDecimalFormat(amountHeld) + " -> " + MenuTools.outputSixDecimalFormat(amountHeld.subtract(proposedAmountBigDecimal)));
                System.out.println("\nUSD:" + "\nFrom: " + MenuTools.outputMoneyFormat(wallet.getUSDBalance()) + " -> " + MenuTools.outputMoneyFormat(wallet.getUSDBalance().add(proposedSellValue)));
                System.out.println("\nAccept?");
                System.out.println("1) Yes");
                System.out.println("2) No");
                int input = keyboard.nextInt();
                while (input != 1 && input != 0) {
                    System.out.println("Invalid choice.");
                    System.out.println("Accept?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");
                    input = keyboard.nextInt();
                }

                //after the user agrees, perform the trade
                //add usd value usd held
                wallet.setUSDBalance(usdHeld.add(proposedSellValue));

                //remove that portion of crypto held
                wallet.getHoldings().get(cryptoPosition).setAmountHeld(amountHeld.subtract(proposedAmountBigDecimal));

                //create and add trade to the wallet
                Trade trade = new Trade(wallet.getHoldings().get(cryptoPosition).getSymbol(), "USD", new BigDecimal(proposedAmountToSell), proposedSellValue);

                //add the trade value to the totalTradeAmount in the wallet
                wallet.setTotalAmountTraded(wallet.getTotalAmountTraded().add(proposedSellValue));

                //return to the trading area
                wallet.addTrade(trade);


                return true;


            }
            return false;

        } catch (IOException e) {
            e.printStackTrace();
            APICalls.apiError();
            return false;
        }

    }

    // This method checks that Crypto - > USD trades are possible
    // This is basically selling Crypto.
    private static boolean checkTradeCryptoToUSD(Wallet wallet, double proposedAmountToSell, int cryptoPosition) {

        BigDecimal proposedAmountBigDecimal = new BigDecimal(proposedAmountToSell);
        return (wallet.getHoldings().get(cryptoPosition).getAmountHeld().compareTo(proposedAmountBigDecimal) > 0 && proposedAmountBigDecimal.compareTo(BigDecimal.ZERO) > 0);

    }

    static boolean tradeUsdToCrypto(int cryptoPosition, Wallet wallet) {

        try {

            String cryptoSymbol = wallet.getHoldings().get(cryptoPosition).getSymbol();
            double currentValueDouble = APICalls.getSingleValue(cryptoSymbol).getValue();
            BigDecimal currentValue = new BigDecimal(currentValueDouble);
            System.out.println("\nSelling " + cryptoSymbol + ":");
            System.out.println("USD Value: " + MenuTools.outputMoneyFormat(currentValueDouble));

            //ask the user how much they want to sell
            System.out.println("How much (of amount held) to sell?");
            Scanner keyboard = new Scanner(System.in);
            double proposedAmountToSell = keyboard.nextDouble();
            while (proposedAmountToSell < 0) {
                System.out.println("Invalid amount, choose a valid amount.");
                proposedAmountToSell = keyboard.nextDouble();
            }

            //if the trade is valid, perform the trade
            //1. remove the amount held from the crypto
            //2. add the USD balance to balance
            //3. add trade record to trades in wallet

            if (checkTradeCryptoToUSD(wallet, proposedAmountToSell, cryptoPosition)) {
                //get the total amount held of the crypto
                BigDecimal amountHeld = wallet.getHoldings().get(cryptoPosition).getAmountHeld();
                //get usd held
                BigDecimal usdHeld = wallet.getUSDBalance();


                //calculate USD value of proposed amount to sell
                BigDecimal proposedAmountBigDecimal = new BigDecimal(proposedAmountToSell);
                BigDecimal proposedSellValue = currentValue.multiply(proposedAmountBigDecimal);

                //check with the user and display trade data
                System.out.println("\n###############");
                System.out.println("Proposed Trade");
                System.out.println("###############");
                System.out.println(wallet.getHoldings().get(cryptoPosition).getSymbol() + ":" + "\nFrom: " + MenuTools.outputSixDecimalFormat(amountHeld) + " -> " + MenuTools.outputSixDecimalFormat(amountHeld.subtract(proposedAmountBigDecimal)));
                System.out.println("\nUSD:" + "\nFrom: " + MenuTools.outputMoneyFormat(wallet.getUSDBalance()) + " -> " + MenuTools.outputMoneyFormat(wallet.getUSDBalance().add(proposedSellValue)));
                System.out.println("\nAccept?");
                System.out.println("1) Yes");
                System.out.println("2) No");
                int input = keyboard.nextInt();
                while (input != 1 && input != 0) {
                    System.out.println("Invalid choice.");
                    System.out.println("Accept?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");
                    input = keyboard.nextInt();
                }

                //after the user agrees, perform the trade
                //add usd value usd held
                wallet.setUSDBalance(usdHeld.add(proposedSellValue));

                //remove that portion of crypto held
                wallet.getHoldings().get(cryptoPosition).setAmountHeld(amountHeld.subtract(proposedAmountBigDecimal));

                //create and add trade to the wallet
                Trade trade = new Trade(wallet.getHoldings().get(cryptoPosition).getSymbol(), "USD", new BigDecimal(proposedAmountToSell), proposedSellValue);

                //add the trade value to the totalTradeAmount in the wallet
                wallet.setTotalAmountTraded(wallet.getTotalAmountTraded().add(proposedSellValue));

                //return to the trading area
                wallet.addTrade(trade);


                return true;


            }
            return false;

        } catch (IOException e) {
            e.printStackTrace();
            APICalls.apiError();
            return false;
        }

    }

    // This method checks that Crypto - > Crypto trades are possible
    private boolean checkTradeUsdToCrypto(Wallet wallet, double proposedAmountToSell, int cryptoPosition) {

        BigDecimal proposedAmountBigDecimal = new BigDecimal(proposedAmountToSell);
        return (wallet.getHoldings().get(cryptoPosition).getAmountHeld().compareTo(proposedAmountBigDecimal) > 0 && proposedAmountBigDecimal.compareTo(BigDecimal.ZERO) > 0);
    }

    // SETTERS AND GETTERS
    UUID getTradeID() {
        return tradeID;
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

    String getToSymbol() {
        return toSymbol;
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }


}


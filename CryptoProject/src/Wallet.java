/*
The wallet is a the class that is essentially the user profile; it is the container for this entire application.
Each wallet object has funding, holdings, personal information, trade history, and goals.
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

public class Wallet {

    private ArrayList<Cryptocurrency> holdings;
    private UUID walletID;
    private String username;
    private EncryptionService encryption;
    private String firstName;
    private String lastName;
    private ArrayList<Trade> trades;
    private byte[] password;
    private BigDecimal totalAmountTraded;
    private BigDecimal totalUSDdeposited;
    private BigDecimal totalUSDwithdrawn;
    private BigDecimal USDBalance;

    // Parameterized constructor
    // The user will always supply a username, first name, and last name.
    Wallet(String firstName, String lastName, String username) {
        holdings = new ArrayList<>();
        walletID = UUID.randomUUID();
        this.username = username;
        encryption = new EncryptionService();
        this.firstName = firstName;
        this.lastName = lastName;
        trades = new ArrayList<>();
        password = new byte[0];
        USDBalance = new BigDecimal(0);
        totalAmountTraded = new BigDecimal(0);
        totalUSDdeposited = new BigDecimal(0);
        totalUSDwithdrawn = new BigDecimal(0);

    }

    // this method adds up the usd value of each cryptocurrency (current value * amount held) and returns it. it does NOT
    // include USD.
    public BigDecimal getTotalHoldings() {

        BigDecimal totalValue = new BigDecimal(0);

        for (Cryptocurrency holding : holdings) {
            totalValue = totalValue.add(holding.getCurrentHoldingValue());
        }
        return totalValue;
    }

    // this method adds an amount to the usd. They can always add money, no check needed.
    public boolean deposit(BigDecimal addAmount) {
        USDBalance = USDBalance.add(addAmount);
        return true;
    }

    // this method checks that the user can withdraw, then if they can it does it. otherwise returns false.
    public boolean withdraw(BigDecimal withdrawAmount) {
        if (USDBalance.compareTo(withdrawAmount) >= 0) {
            USDBalance = USDBalance.subtract(withdrawAmount);
            return true;
        } else {
            return false;
        }
    }

    // This method shows basic info on each trade.
    private void showTrades() {

        trades.forEach(trade -> {
            System.out.println("Trade ID: " + String.valueOf(trade.getTradeID()));
            System.out.println("Date of Trade: " + String.valueOf(trade.getDateTime()));
            System.out.println("From: " + String.valueOf(trade.getFromSymbol()));
            System.out.println("To: " + String.valueOf(trade.getToSymbol()));
            System.out.println("Amount: " + String.valueOf(trade.getFromAmount().subtract(trade.getToAmount())));

        });


    }

    //TODO Set password in Wallet using this
    public boolean setPassword(EncryptionService object) {
        // this.password = new byte[object.getEncryptedAttemptedPassword()]; ??
        // return true;
        // return false;
        // Jon - leave this to me. I'll be helping.
        return true;

    }

    //TODO Change password (no confirmation required)
    public boolean changePassword() {
        // ASSUMING THIS WILL CONNECT WITH PasswordEncryptionService class?
        // COME BACK TO THIS
        // Jon - this calls its own object of the PasswordEncryptionService. This will simply ask for and set a new pass.

        return true;
    }

    //TODO-Review Set goals based on comments below.
    public boolean setGoal(BigDecimal goal) {
        // This class will add up all the holdings into USD and then display true when the netprofit is higher than the
        // goal, or equal to the goal


        // The user needs to specify what the goal they want to reach is. The program asks for user input. I'm not
        // sure where to ask for the user input, so I'm putting it here for review. For now, I have set the goal to null.

       /* Scanner scan=   new Scanner(System.in);
        System.out.println(" Enter your goal: ");
        goal= scan.nextBigDecimal();*/

        goal=null;
        BigDecimal total= USDBalance.add(getTotalHoldings());

        BigDecimal netprofit= total.subtract(totalUSDdeposited);

        if (netprofit.compareTo(goal)==1) {

            return true;

        }
        else if (netprofit.compareTo(goal)==0){
            return true;
        }

        else
        {
            return false;
        }

    }

    // This class shows general Wallet data.
    public void showWalletData() {

        System.out.println("Hello "+ firstName+" "+ lastName);


        System.out.println("Wallet ID: " + walletID);
        System.out.println("Balance: " + USDBalance);
        System.out.println("Total USD Deposited: "+ totalUSDdeposited);
        System.out.println("Total USD Withdrawn: "+ totalUSDwithdrawn);
        System.out.println("Total amount traded: " + totalAmountTraded);

        System.out.println("You have traded in the following: ");
        showTrades();
       // ConsoleUtils has a method called viewPerformanceandGoals. Add it here to show the how the user is
        // performing.
        }

    public ArrayList<Cryptocurrency> getHoldings() {
        return new ArrayList<>();
    }

    public void setHoldings(ArrayList<Cryptocurrency> holdings) {
        this.holdings = holdings;
    }

    public BigDecimal getUSDBalance() {
        return USDBalance;
    }


    public UUID getWalletID() {
        return walletID;
    }


    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }


}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //goes to the menu
        int selection = menu();

        //analyzes the selection returned
        switch (selection) {

            case 0:
                ConsoleTools.lineBreak();
                System.out.println("Exiting program...");
                System.exit(0);
                break;

            case 1:
                ConsoleTools.lineBreak();
                browse();
                break;

            case 2:
                ConsoleTools.lineBreak();
                wallet();
                break;

            case 3:
                ConsoleTools.lineBreak();
                trading();
                break;

            case 4:
                ConsoleTools.lineBreak();
                indicators();
                break;

            case 5:
                ConsoleTools.lineBreak();
                help();

            default:
                System.out.println("\nEnter a valid choice!");
                menu();
                break;

        }

        //returns to the menu every time an option is exited
        menu();

    }

    //has the user choose what they want to do
    private static int menu() {

        //creates objects and variables for menu system
        int selection;
        Scanner keyboard = new Scanner(System.in);

        //outputs the menu options
        ConsoleTools.lineBreak();
        System.out.println("Simulated Cryptocurrency Wallet and Trading v0.01");
        System.out.println("\nChoose an option below by typing the number:");
        System.out.println("1) Browse Currencies");
        System.out.println("2) View Wallet");
        System.out.println("3) Trading");
        System.out.println("4) Use Indicators");
        System.out.println("5) Help");
        System.out.println("0) Exit");

        //captures the user selection
        System.out.print("\nSelection? ");

        selection = keyboard.nextInt();

        return selection;


    }

    //this method will help the user to browse historical and current values of cryptocurrencies using CCXT
    private static void browse() {

        System.out.println("Loading cryptocurrency browser ...");
        ConsoleTools.underConstruction();
        System.out.println("This section of the program will show current and past cryptocurrency values.");
        System.out.println("Press enter to return to the menu.");
        ConsoleTools.promptEnterKey();

    }

    //this holds wallet information (funds, currencies)
    private static void wallet() {

        System.out.println("Opening wallet ...");
        ConsoleTools.underConstruction();
        System.out.println("This section will show you your wallet and funds.");
        System.out.println("Press enter to return to the menu.");
        ConsoleTools.promptEnterKey();

    }

    //this has trading views and options to buy and sell
    private static void trading() {

        System.out.println("Launching trading system ...");
        ConsoleTools.underConstruction();
        System.out.println("This section will allow you to buy and sell cryptocurrencies.");
        System.out.println("Press enter to return to the menu.");
        ConsoleTools.promptEnterKey();

    }

    //this has custom algorithms to help people predict what to do
    private static void indicators() {

        System.out.println("Loading Indicators ...");
        ConsoleTools.underConstruction();
        System.out.println("This section will use algorithms to help you make better decisions.");
        System.out.println("Press enter to return to the menu.");
        ConsoleTools.promptEnterKey();

    }

    //this has information about the program and cryptocurrencies
    private static void help() {

        System.out.println("Loading help ...");
        ConsoleTools.underConstruction();
        System.out.println("This section will display About and Help information.");
        System.out.println("Press enter to return to the menu.");
        ConsoleTools.promptEnterKey();

    }

}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //goes to the menu
        int selection = menu();

        //analyzes the selection returned
        switch (selection) {

            case 0:
                clearConsole();
                System.out.println("Exiting program...");
                System.exit(0);
                break;

            case 1:
                System.out.println("Opening cryptocurrency browser...");
                browse();
                break;

            case 2:
                //wallet();
                break;

            case 3:
                //trading();
                break;

            case 4:
                //indicators();
                break;

            case 5:
                //help();

            default:
                //selection = menu();
                break;

        }

    }

    //this method will help the user to browse historical and current values of cryptocurrencies using CCXT
    private static void browse() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("This section of the program will show current and past cryptocurrency values.");
        System.out.println("Press enter to return to the menu.");
        keyboard.next();

    }

    //has the user choose what they want to do
    private static int menu() {

        //creates objects and variables for menu system
        int selection;
        Scanner keyboard = new Scanner(System.in);

        //outputs the menu options
        System.out.println("Simulated Cryptocurrency Wallet v0.01");
        System.out.println("\nChoose an option below by typing the number:");
        System.out.println("1) Browse Currencies");
        System.out.println("2) View Wallet");
        System.out.println("3) Trading");
        System.out.println("4) Use Indicators");
        System.out.println("5) Help");
        System.out.println("0) Exit");

        //captures the user selection
        selection = keyboard.nextInt();

        return selection;


    }

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

}
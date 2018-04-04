/*
This class contains useful console tools for this project. We need tools because we want this project
to be easy to use and the interface to be uncluttered.
*/

import java.util.Scanner;


class ConsoleUtils {

    // Adds a nice separator to different activities, doesn't clear the screen
    private static void lineBreak() {

        System.out.println("\n-----------------------------------------------------------");
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("-----------------------------------------------------------\n");

    }

    // After authentication or account creation, the program comes here.
    private static void menu(Wallet wallet) {

        //creates objects and variables for menu system
        int selection;
        Scanner keyboard = new Scanner(System.in);

        //outputs the menu options
        ConsoleUtils.lineBreak();
        ConsoleUtils.title();
        System.out.println("\nWelcome " + wallet.getFirstName() + ", or should I say: " + wallet.getUsername());
        System.out.println("\nChoose an option below by typing the number:");
        System.out.println("1) View Wallet");
        System.out.println("2) Browse Currencies");
        System.out.println("3) Trades");
        System.out.println("4) Goals and Performance");
        System.out.println("5) Deposit USD");
        System.out.println("6) Withdraw USD");
        System.out.println("7) Help");
        System.out.println("0) Save & Exit");
        System.out.println("\n USD Balance: " + wallet.getUSDBalance());

        //captures the user selection
        System.out.print("\nSelection? ");

        selection = keyboard.nextInt();

        switch (selection) {

            case 1:
                ConsoleUtils.lineBreak();
                viewWallet(wallet);
                break;

            case 2:
                ConsoleUtils.lineBreak();
                browseCryptocurrencies(wallet);
                break;

            case 3:
                ConsoleUtils.lineBreak();
                trade(wallet);
                break;

            case 4:
                ConsoleUtils.lineBreak();
                goalsAndPerformance(wallet);
                break;

            case 5:
                ConsoleUtils.lineBreak();
                depositUSD(wallet);
                break;

            case 6:
                ConsoleUtils.lineBreak();
                withdrawUSD(wallet);
                break;

            case 7:
                ConsoleUtils.lineBreak();
                help(wallet);
                break;

            case 0:
                ConsoleUtils.lineBreak();
                System.out.println("Saving wallet to file...");

                //saves the wallet
                if (FileOperations.saveWallet(wallet)) {
                    System.out.println("Wallet saved!");
                } else {
                    System.out.println("Wallet could not be saved.");
                    System.exit(0);
                }

                System.out.println("Exiting program...");
                System.exit(0);
                break;

            default:
                System.out.println("\nEnter a valid choice!");
                System.exit(0);
                break;

        }


    }

    private static void withdrawUSD(Wallet wallet) {


    }

    private static void depositUSD(Wallet wallet) {

    }

    //TODO Implement a menu for people to view/edit goals and view performance.
    // This method lets users view and set goals as well as view performance.
    private static void goalsAndPerformance(Wallet wallet) {

    }

    // Outputs the title and version of the program.
    private static void title() {
        System.out.println("Virtual Cryptocurrency Wallet and Trading v0.10");
    }

    // Uses Coinbase exchange to output information
    private static void browseCryptocurrencies(Wallet wallet) {

        System.out.println("Loading cryptocurrency browser ...");


        System.out.println("Press enter to return to the menu.");
        promptEnterKey();
        menu(wallet);

    }

    // Holds viewWallet information (funds, currencies)
    private static void viewWallet(Wallet wallet) {

        System.out.println("Opening viewWallet ...");
        ConsoleUtils.underConstruction();
        System.out.println("This section will show you your Wallet and funds.");
        System.out.println("Press enter to return to the menu.");
        promptEnterKey();
        menu(wallet);
    }

    // Has trading views and options to buy and sell
    private static void trade(Wallet wallet) {

        System.out.println("Launching trading system ...");
        ConsoleUtils.underConstruction();
        System.out.println("This section will allow you to buy and sell cryptocurrencies.");
        System.out.println("Press enter to return to the menu.");
        promptEnterKey();

        menu(wallet);

    }

    // Information about the program and cryptocurrencies
    private static void help(Wallet wallet) {

        lineBreak();
        title();
        System.out.println("This application is a VIRTUAL trading application that is both a proof of concept, and" +
                "a working trade application. This application was created for our Java class, but can eventually be" +
                "adapted to perform a wider variety of tasks.");
        System.out.println("\nResources used:");
        System.out.println("- XChange");
        System.out.println("- Coinbase Exchange API");
        System.out.println("- ");



        System.out.println("Press enter to return to the menu.");
        promptEnterKey();
        menu(wallet);

    }

    // This makes the method continue when enter is pressed.
    private static void promptEnterKey() {

        System.out.print("Press enter to continue");
        Scanner enterKey = new Scanner(System.in);
        enterKey.nextLine();
    }

    // Stub for areas under construction.
    private static void underConstruction() {
        System.out.println("UNDER CONSTRUCTION!");
    }

    // This method is called by menu before showing the menu to make sure the user has an account (viewWallet)
    // If not, they can create it here.
    static void launchScreen() {


        title();

        //if the loginInfo.ser file doesn't exist, create a blank one, save it, and send user to account creation
        if (!FileOperations.checkLoginInfoExists()) {

            LoginInfo loginInfo = new LoginInfo();
            FileOperations.saveLoginInfo(loginInfo);
            createNewAccount();
        }


        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) Login");
        System.out.println("2) Create Wallet");

        int response = keyboard.nextInt();

        //Input validation
        while (response != 1 && response != 2) {

            lineBreak();
            title();
            System.out.println("Invalid response!");
            System.out.println("1) Login");
            System.out.println("2) Create Wallet");

            response = keyboard.nextInt();
        }

        //If they pass input validation, they will be directed to the next area.

        // Send launchScreen to the right place depending on their input
        if (response == 1) {
            logIn();
        } else {
            createNewAccount();
        }

    }

    // This method creates a new viewWallet
    private static void createNewAccount() {

        Scanner keyboard = new Scanner(System.in);

        // Gather information about the viewWallet
        lineBreak();
        System.out.println("Let's create a Wallet for you.");
        System.out.println("Please enter the following information:");
        System.out.print("First Name: ");
        String firstName = keyboard.next();
        System.out.print("Last Name: ");
        String lastName = keyboard.next();
        System.out.println("\nThank you. Now enter a username and password; this will be what you use to login in the future.");
        System.out.print("Username: ");
        String username = keyboard.next();
        System.out.print("Password: ");
        String password = keyboard.next();

        // Add the login pair to the LoginInfo object
        LoginInfo loginInfo = FileOperations.loadLoginInfo();
        loginInfo.addUserAndPassword(username, password);

        // Save the LoginInfo object
        if (FileOperations.saveLoginInfo(loginInfo)) {
            System.out.println("Login information saved.");
        } else {
            System.out.println("Login information could not be saved.");
            System.exit(0);
        }

        // Create the viewWallet and send the user to the menu
        Wallet wallet = new Wallet(firstName, lastName, username);
        System.out.println("\nThanks " + firstName + ", wallet created!");
        System.out.println("You can set goals, trade, and browse currencies at the main menu. Going there now..");
        promptEnterKey();


        menu(wallet);
    }

    // This class handles logging in and is run before the menu is displayed.
    private static void logIn() {


        lineBreak();
        int loginAttempts = 1;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Username: ");
        String username = keyboard.next();
        System.out.print("Password: ");
        String password = keyboard.next();

        loginAttempts++;

        // Load login info
        LoginInfo loginInfo = FileOperations.loadLoginInfo();

        // Not authenticated
        while (!loginInfo.isAuthenticated(username, password)) {

            if (loginAttempts > 3) {

                // If they enter a wrong combo 3 times, kick them out
                System.out.println("Too many attempts, exiting program.");
                System.exit(0);
            }

            System.out.println("Not authenticated, try again.");
            System.out.println("Attempt " + loginAttempts + " of 3.");
            System.out.print("Username: ");
            username = keyboard.next();
            System.out.print("Password: ");
            password = keyboard.next();
            loginAttempts++;
        }

        // Authenticated
        System.out.println("Authenticated!");
        System.out.println("Going to the menu now...");
        promptEnterKey();


        //Load the wallet matching their username
        Wallet wallet = FileOperations.loadWallet(username);
        if (wallet != null) {
            menu(wallet);
        } else {
            System.out.println("Could not load wallet from username: " + username);
        }


    }
}


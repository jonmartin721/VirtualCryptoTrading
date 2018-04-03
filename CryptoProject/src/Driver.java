/*
This class should be the driver and contains code that uses the other classes in the application.
 */

import java.io.IOException;

public class Driver {

    public static void main(String[] args) {

        // Main is just the starting point for this application and doesn't do anything other than call menu();
        // Test code can go here before passing the program off to consoleUtils
        String testingUsername = "admin";
        String testingPassword = "popcorn";

        LoginInfo testingLoginInfo = new LoginInfo();
        testingLoginInfo.addUserAndPassword(testingUsername, testingPassword);
        try {
            FileOperations.saveLoginInfo(testingLoginInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Actual program starts here
        ConsoleUtils.menu();

    }


}
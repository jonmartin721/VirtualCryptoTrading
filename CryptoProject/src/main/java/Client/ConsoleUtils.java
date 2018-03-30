package Client;

/*
This class contains useful console tools for this project. We need tools because we want this project
to be easy to use and the interface to be uncluttered.
*/

import java.util.Scanner;

public class ConsoleUtils {

    //adds a nice separator to different activities, doesn't clear the screen
    public static void lineBreak() {

        System.out.println("\n-----------------------------------------------------------");
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("-----------------------------------------------------------\n");

    }


    //this will eventually have code for a loading cursor when the program is fetching info
    public static void loadingCursor() {
        System.out.println();
    }

    //This makes the method continue when enter is pressed.
    public static void promptEnterKey() {
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
    }

    //This method is a stub for areas under construction.
    public static void underConstruction() {
        System.out.println("UNDER CONSTRUCTION!");
    }


}

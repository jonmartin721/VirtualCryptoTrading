import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

class LoginInfo implements Serializable {


    private HashMap<String, String> usersAndPasswords = new HashMap<>();

    // Looks through the map and returns true if the user specified is an authenticated user
    // That is: if they are a user, and the password entered is correct
    boolean isAuthenticated(String username, String password) {
        return usersAndPasswords.containsKey(username) && usersAndPasswords.get(username).equals(password);
    }

    // Lets users add a username and password to the map
    boolean addUserAndPassword(String username, String password) {

        boolean accepted = false;
        while (usersAndPasswords.containsKey(username)){

            // Checks to see if the username is unique
            // Still need to work on this some more
            Scanner keyboard=new Scanner(System.in);
        System.out.println("This username already exits. Please choose another.");
        System.out.println("Enter New Username: ");
        username = keyboard.next();



        }
            // Saves the username and password to a hashmap
            usersAndPasswords.put(username, password);
            return true;




    }

    // Removes a username and password.
    boolean removeUserAndPassword(String key) {

        usersAndPasswords.remove(key);
        return true;
    }

    int returnSize() {
        return usersAndPasswords.size();
    }


}

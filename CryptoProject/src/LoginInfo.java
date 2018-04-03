import java.io.Serializable;
import java.util.HashMap;

public class LoginInfo implements Serializable {


    private HashMap<String, String> usersAndPasswords = new HashMap<>();

    // This method looks through the map and returns true if the user specified is an authenticated user
    public boolean isAuthenticated(String username, String password) {
        return usersAndPasswords.containsKey(username) && usersAndPasswords.get(username).equals(password);
    }

    // This method lets users add a username and password to the map
    void addUserAndPassword(String username, String password) {

        usersAndPasswords.put(username, password);

    }

    // This method displays all key/value pairs in the loginInfo map.
    void displayContents() {

        for (String username : usersAndPasswords.keySet()) {

            String value = usersAndPasswords.get(username);
            System.out.println(username + " " + value);

        }

    }
}

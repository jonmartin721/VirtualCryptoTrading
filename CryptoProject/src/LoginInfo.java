import java.io.Serializable;
import java.util.HashMap;

public class LoginInfo implements Serializable {


    private HashMap<String, String> usersAndPasswords = new HashMap<>();

    public boolean isAuthenticated(String username, String password) {
        return usersAndPasswords.containsKey(username) && usersAndPasswords.get(username).equals(password);
    }

    public void addUserAndPassword(String username, String password) {

        usersAndPasswords.put(username, password);

    }
}

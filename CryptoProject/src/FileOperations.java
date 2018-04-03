/*
This class handles saving and loading data from file. It will be done on the server side and sent to the clients.
Data will be serialized out to a file. I'm not sure yet if each wallet will be its own file, or if all wallets will
be put into one file.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileOperations {

    //TODO -Amee-Serialize the wallet out to a file
    private Wallet saveData;

    //this method will save the wallet passed into it as a serialized object
    public boolean saveWallet(Wallet wallet) {

        return true;

    }

    //TODO -Amee-Deserialize a wallet from file into an object.
    public Wallet loadWallet() {


        return new Wallet("Bob", "Bobby", "Bob123");

    }

    public static boolean saveLoginInfo(LoginInfo loginInfo) throws IOException {

        FileOutputStream fout = null;
        fout = new FileOutputStream("loginInfo.ser", true);
        try (ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(loginInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        fout.close();

        return true;
    }

}

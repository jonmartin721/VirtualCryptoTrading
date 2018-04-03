/*
This class handles saving and loading data from file. It will be done on the server side and sent to the clients.
Data will be serialized out to a file. I'm not sure yet if each wallet will be its own file, or if all wallets will
be put into one file.
 */

import java.io.*;

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


    // This method saves login information to a "loginInfo.ser"
    static boolean saveLoginInfo(LoginInfo loginInfo) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("loginInfo.ser", true);
        try (ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
            oos.writeObject(loginInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        fileOutputStream.close();

        return true;
    }

    // This method loads login information (usernames and passwords) from a serialized LoginInfo object
    static LoginInfo loadLoginInfo() {


        LoginInfo loginInfo = null;

        try {

            FileInputStream file = new FileInputStream("loginInfo.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            loginInfo = (LoginInfo) in.readObject();

            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IO Exception.");
            System.out.println("Serial UID may have changed.");

        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found.");
        }


        return loginInfo;

    }

}

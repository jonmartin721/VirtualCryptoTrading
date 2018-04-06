/*
This static utility class handles saving and loading data from file. It will be done on the server side and sent to the clients.
Data will be serialized out to a file. Each user will have one wallet file. This also handles saving and loading login information.

Most exceptions are handled here, so as to be easy to consume and process.
 */

import java.io.*;

class FileOperations {

    // Saves the wallet passed into it as a serialized object
    static boolean saveWallet(Wallet wallet) {

        String fileName = wallet.getUsername() + "_wallet.ser";

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName, false)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
                oos.writeObject(wallet);
            } catch (Exception ex) {
                printException();
                ex.printStackTrace();
                return false;
            }

        } catch (IOException e) {
            printIoException();
            e.printStackTrace();
        }

        return true;

    }

    // Loads a wallet from file. To reach this method in normal flow, it SHOULD exist.
    static Wallet loadWallet(String username) throws IOException, ClassNotFoundException {

        String fileName = username + "_wallet.ser";

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        // Read and return the specific wallet with the username
        return (Wallet) in.readObject();

    }

    // This method saves login information to a "loginInfo.ser"
    static boolean saveLoginInfo(LoginInfo loginInfo) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("loginInfo.ser", false)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
                oos.writeObject(loginInfo);
            } catch (Exception ex) {
                printException();
                ex.printStackTrace();
                return false;
            }

        } catch (IOException e) {
            printIoException();
            e.printStackTrace();
        }

        return true;
    }

    // This method loads login information (usernames and passwords) from a serialized LoginInfo object
    static LoginInfo loadLoginInfo() {

        LoginInfo loginInfo;

        //try to load the file
        try {
            FileInputStream file = new FileInputStream("loginInfo.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            loginInfo = (LoginInfo) in.readObject();
            in.close();
            file.close();
        }

        //catch errors that can happen by loading files. If there is a class mismatch, create a new LoginInfo and return it
        catch (IOException | ClassNotFoundException ex) {
            printIoException();
            System.out.println("Deleting old loginInfo.ser....");
            File file = new File("loginInfo.ser");
            if (file.delete()) {
                System.out.println("Deleted.");
            }
            System.out.println("Creating new loginInfo.ser....");
            return new LoginInfo();
        }

        return loginInfo;

    }

    static boolean checkLoginInfoExists() {

        String filePathString = "loginInfo.ser";
        File f = new File(filePathString);
        return f.exists() && !f.isDirectory();

    }

    private static void printIoException() {
        System.out.println("FileOperations I/O error encountered while trying to read/write:");
    }

    static void printException() {
        System.out.println("Exception:");
    }

}

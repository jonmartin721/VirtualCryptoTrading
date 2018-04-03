package Server;

/*
This class handles saving and loading data from file. It will be done on the server side and sent to the clients.
Data will be serialized out to a file. I'm not sure yet if each wallet will be its own file, or if all wallets will
be put into one file.
 */

import Wallet;

import java.io.*;


public class FileOperations implements java.io.Serializable{

    //TODO -Amee-Serialize the wallet out to a file

    private Wallet saveData;    // variable

    //this method will save the wallet passed into it as a serialized object
    public boolean saveWallet(Wallet wallet) {
        // created a file object from FileOutputStream class to write the object into
        // created an ObjectOutputStream

        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("walletFile.ser"));
            out.writeObject(wallet);

            out.close();
            System.out.println("Serialized data is saved in walletFile.ser");
            return true;
        }
        catch (IOException i){
            i.printStackTrace();
            return false;
        }

    }

    //TODO -Amee-Deserialize a wallet from file into an object.
    public Wallet loadWallet(Wallet walletToLoad) {
        this.saveData = null;

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("walletFile.ser"));

            //read in objects and compare til we find specific UUID
            this.saveData = (Wallet) in.readObject();
            if (saveData instanceof Wallet){
                //Wallet retrieveWallet = (Wallet) saveData;
                System.out.println("Found UUID");
            }
            return saveData;


        }
        catch (IOException i){
            System.err.println("### Error opening file. ###");
        }
        catch (ClassNotFoundException c){
            System.err.println("### Object creation failed. ###");
        }

        // Jon if code makes it down here then it returns a new Wallet as you originally implemented
        System.out.println("*** Returning a new Wallet ***");
        return new Wallet("Bob", "Bobby", "Bob123");

    }

}

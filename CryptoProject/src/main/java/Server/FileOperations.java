package Server;

/*
This class handles saving and loading data from file. It will be done on the server side and sent to the clients.
Data will be serialized out to a file. I'm not sure yet if each wallet will be its own file, or if all wallets will
be put into one file.
 */

import Client.Wallet;

import java.io.*;


public class FileOperations implements java.io.Serializable{

    //TODO -Amee-Serialize the wallet out to a file

    private Wallet saveData;    // variable

    //this method will save the wallet passed into it as a serialized object
    public boolean saveWallet(Wallet wallet) {
        // created a file object from FileOutputStream class to write the object into
        // created an ObjectOutputStream
        try{
            FileOutputStream fileout = new FileOutputStream("walletFile.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(wallet);

            // closing all resources
            out.close();
            fileout.close();
            System.out.println("Serialized data is saved in walletFile.ser");
            return true;
        }
        catch (IOException i){
            i.printStackTrace();
            return false;
        }

    }

    //TODO -Amee-Deserialize a wallet from file into an object.
    public Wallet loadWallet() {
        // created a FileInputStream object and set it to the serialized file we want to pull from
        // created an ObjectInputstream
        Wallet obj;
        try {
            FileInputStream fileIn = new FileInputStream("walletFile.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = (Wallet) in.readObject();

            // closing all resources
            in.close();
            fileIn.close();
            return obj;
        }
        catch (IOException i){
            System.out.println("Error: ### Wallet not found ####");
        }
        catch (ClassNotFoundException c){
            System.out.println();
        }
        System.out.println();
        return new Wallet("Bob", "Bobby", "Bob123");
        // **JON-Need to confirm this line above with Jon- so if nothing comes out of the .ser file,
        // then a new Wallet is created?

    }

}

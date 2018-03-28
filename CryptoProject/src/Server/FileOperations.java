package Server;

/*
This class handles saving and loading data from file. It will be done on the server side and sent to the clients.
Data will be serialized out to a file. I'm not sure yet if each wallet will be its own file, or if all wallets will
be put into one file.
 */

import Client.Wallet;

public class FileOperations {

    private Wallet saveData; //TODO Decide if this class needs to be instantiated at all, or can be a static utility class.

    //this method will save the wallet passed into it as a serialized object
    public boolean saveWallet(Wallet wallet) {

        return true;

    }

    //this method will load a wallet.
    public Wallet loadWallet() {


        return new Wallet("Bob", "Bobby", "Bob123");

    }

}

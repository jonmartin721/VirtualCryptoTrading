
/*
This class performs the networking operations on the server side. I'm not sure how this is going to be implemented in
our project, we don't have all the details yet.
 */

public class ServerNetworking {

    private int networkData;
    private FileOperations fileOperations;

    // Sends save data.
    public static boolean receiveSaveData(int data) {

        return true;

    }

    // Sends data of some kind to the server, any kind but save data.
    public boolean sendData(int data) {

        return true;

    }

    // Returns the data being sent by the server.
    public int receiveData() {

        return 0;

    }

    // Can be used to regularly checks for connection status with the server.
    public int getConnectionStatus() {

        return 0;

    }

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.FileSystem;

 // Simple client class. This class connects to an EchoServer to send text back
 // and forth. Java message serialization is used to pass Message objects around.

public class EchoClient {

    private static FileSystem sock;

    public static void main(String[] args) {
        try {
            String serverName;

            //Prompt the user to enter the Server to connect to
            System.out.println("Enter Server name or IP > \n");
            System.out.print(" > ");

            //Read user input for the server name or IP address 
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            serverName = in.readLine();

            // Connect to the specified server
            final Socket sock = new Socket(serverName, EchoServer.SERVER_PORT);
            System.out.println("Connected to " + serverName + " on port " + EchoServer.SERVER_PORT);
            MenuTools.lineDivider();

            // Set up I/O streams with the server
            final ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
            final ObjectInputStream input = new ObjectInputStream(sock.getInputStream());

            // loop to send messages
            Message msg, resp;
            do {
                //System.out.println("In do-while loop of EchoClient class");
                // Read and send message.
                msg = new Message(readSomeText());
                output.writeObject(msg);

                // Get ACK and print.
                // Note that we need explicitly cast the return from readObject() to the type Message.
                resp = (Message) input.readObject();

                System.out.println("\nServer says: " + resp.theMessage + "\n");

            } while (!msg.theMessage.toUpperCase().equals("EXIT"));

            // shut things down
            sock.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
        }

    } //-- end main(String[])


    // Simple method to print a prompt and read a line of text. @return A line of text read from the console
    private static String readSomeText() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            MenuTools.launchScreen();
            return in.readLine();
        } catch (Exception e) {
            return "Uh oh...";
        }
    } //-- end readSomeText2()


    static void exitProgramAndServer(){
        try {
            System.out.println("Type \"EXIT\" to quit this program and server.");
            System.out.print(" > ");
            //Read user input for the server name or IP address
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //serverName = in.readLine();
            sock.close();

        } catch (Exception e) {
            System.out.println();
            //System.out.println("Uh, uh, oh...");
        }
    }
} //-- end class EchoClient
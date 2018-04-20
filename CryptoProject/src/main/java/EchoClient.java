import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.FileSystem;

/**
 * Simple client class. This class connects to an EchoServer to send text back
 * and forth. Java message serialization is used to pass Message objects around.
 *
 *
 */
public class EchoClient {

    private static FileSystem sock;

    /**
     * Main method.
     *
     *
     */
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
            Message msg = null, resp = null;
            do {
                //System.out.println("In do-while loop of EchoClient class");
                // Read and send message.  Since the Message class
                // implements the Serializable interface, the
                // ObjectOutputStream "output" object automatically
                // encodes the Message object into a format that can
                // be transmitted over the socket to the server.
                msg = new Message(readSomeText());
                output.writeObject(msg);

                // Get ACK and print.  Since Message implements
                // Serializable, the ObjectInputStream can
                // automatically read this object off of the wire and
                // encode it as a Message.  Note that we need to
                // explicitly cast the return from readObject() to the
                // type Message.
                resp = (Message) input.readObject();

                System.out.println("\nServer says: " + resp.theMessage + "\n");
                //MenuTools.launchScreen();

            } while (!msg.theMessage.toUpperCase().equals("EXIT"));

            // shut things down
            sock.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(System.err);
        }

    } //-- end main(String[])

    /**
     * Simple method to print a prompt and read a line of text.
     *
     * @return A line of text read from the console
     */
    static String readSomeText() {
        try {
            //System.out.println("Enter a line of text, or type \"EXIT\" to quit.");
            //System.out.print(" > ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            MenuTools.launchScreen();
            return in.readLine();
        } catch (Exception e) {
            // Uh oh...
            return "Uh oh...";
        }



    } //-- end readSomeText()
    static void readSomeText2() {
        try {
            System.out.println("Type \"EXIT\" to quit.");
            System.out.print(" > ");
            sock.close();

        } catch (Exception e) {
            // Uh oh...
            System.out.println("Uh, uh, oh...");
        }
    }
} //-- end class EchoClient
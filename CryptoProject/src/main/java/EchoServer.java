import java.net.ServerSocket;
import java.net.Socket;


// A simple server class.  Accepts client connections and forks
// EchoThreads to handle the bulk of the work.

public class EchoServer
{
    /** The server will listen on this port for client connections */
    public static final int SERVER_PORT = 8765;

    /**
     * Main routine.  Just a dumb loop that keeps accepting new
     * client connections.
     */
    public static void main(String[] args)
    {
	try{
	    // This is basically just listens for new client connections
	    final ServerSocket serverSock = new ServerSocket(SERVER_PORT);
	    
	    // A simple infinite loop to accept connections
	    Socket sock = null;
	    EchoThread thread = null;
	    while(true){
		sock = serverSock.accept();     // Accept an incoming connection
		thread = new EchoThread(sock);  // Create a thread to handle this connection
		thread.start();                 // Fork the thread
	    }                                   // Loop to work on new connections while this
                                                // the accept()ed connection is handle
	}
	catch(Exception e){
	    System.err.println("Error: " + e.getMessage());
	    e.printStackTrace(System.err);
	}

    }  //-- end main(String[])

} //-- End class EchoServer
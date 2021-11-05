import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        int port = 8888;
        ServerSocket server;
        Socket socket;

        InetAddress inetAddress;

        Jeoparty jeoparty = null;
        try {
            jeoparty = new Jeoparty();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //> starting thread with game Jeoparty
        new Thread(jeoparty).start();

        try {
            inetAddress = InetAddress.getLocalHost();
            System.out.println("IP-Address:\n" + inetAddress.getHostAddress() + "\nPort:\n" + port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("FAILED SETTING UP ");
        }

        //> Setting up server with given port
        try {
            server = new ServerSocket(port);
            //> Listens for clients
            while(true) {
                socket = server.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED SETTING UP SERVER!");
        }
    }
}
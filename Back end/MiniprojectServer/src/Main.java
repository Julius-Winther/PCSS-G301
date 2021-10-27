import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main implements Serializable {

    public static void main(String args[]) throws IOException {
        //Creatin an object for the gam
        Game game =  new Game();
        //game.loadQuestions();

        //Creating an object for the Host
        Host host = new Host();

        //Hosting the server
        int port = 8000;
        int numberOfClients = 0;

        //> this prints out the information (ip and port) that is needed in order for the client(s) to join the server
        ServerSocket server = new ServerSocket(port);
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Ask the dummy client to enter this IP address:\n" + inetAddress.getHostAddress() + "\nand this port number:\n" + port);

        while (true) {
            Socket socket = server.accept();    //accepts clients

            numberOfClients++;

            if (numberOfClients == 1) {

            }

            inetAddress = socket.getInetAddress();
            System.out.println("InetAddress declared!");

            System.out.println("\nClient number " + numberOfClients + " joined!");
            System.out.println("Client " + numberOfClients + "'s host name is: " + inetAddress.getHostName());
            System.out.println("Client " + numberOfClients + "'s IP-address is: " + inetAddress.getHostAddress() + "\n");

            //> a thread is created for every single client
            //> these threads will handle every in- and outputs from clients
            new Thread(
                    new AcceptingClientTask(socket, "Multithreaded Server")
            ).start();
            System.out.println("Threading done!");

            //Sending all the questionblock variables
            //game.transferBlockOut(socket, output);

            //Receiving name of the first user
            //game.loadPlayerInfo(socket, input);

            //Receiving name and IP of host
            //game.loadHostInfo(socket, input);

            //Sending the info from player
            //game.sendPlayerInfo(socket, output);

            //Sending the info on host to player
            //game.sendHostInfo(socket, output);
        }
    }
}

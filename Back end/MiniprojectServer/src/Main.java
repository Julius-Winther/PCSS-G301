import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main implements Serializable {

    public static void main(String args[]) throws IOException {

        //Creatin an object for the gam
        Game game =  new Game();
        game.loadQuestions();

        //Hosting the server
        String host = "172.20.10.2";
        int port = 9696;
        int numberOfClients = 0;

        ServerSocket server = new ServerSocket(port);

        while (true) {
            Socket socket = server.accept();
            numberOfClients++;

            InetAddress inetAddress = socket.getInetAddress();

            System.out.println("\nClient number " + numberOfClients + " joined!");
            System.out.println("Client " + numberOfClients + "'s host name is: " + inetAddress.getHostName());
            System.out.println("Client " + numberOfClients + "'s IP-address is: " + inetAddress.getHostAddress() + "\n");

            new Thread(
                    new MyTask(socket, "Multithreaded Server")
            ).start();
        }

        System.out.println("Connection from " + socket + "!");

        //Creating input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        //Sending all the questionblock variables
        game.transferBlockOut(socket, output);

        //Receiving name of the first user
        game.loadPlayerInfo(socket, input);

        //Receiving name and IP of host
        game.loadHostInfo(socket, input);

        //Sending the info from player
        game.sendPlayerInfo(socket, output);

        //Sending the info on host to player
        game.sendHostInfo(socket, output);

    }
}

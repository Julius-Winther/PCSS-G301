import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main implements Serializable {

    public static void main(String args[]) throws IOException {
        //Creatin an object for the game
        Game game =  new Game();

        //Joining variables
            //Names
            String hostName;
            String playerName;
            //Creating an object for joining
            Joining joining = new Joining();
            //Player and Host objects
            Host host;
            ArrayList<Player> players = new ArrayList<Player>();

        //Hosting the server
        int port = 8000;
        int numberOfClients = 0;
        int playerID = 0;

        //> this prints out the information (ip and port) that is needed in order for the client(s) to join the server
        ServerSocket server = new ServerSocket(port);
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Ask the dummy client to enter this IP address:\n" + inetAddress.getHostAddress() + "\nand this port number:\n" + port);

        while (true) {

            numberOfClients++;
            while (true) {
                Socket socket = server.accept();    //accepts clients

                if (numberOfClients == 1) {
                    Socket socketHost = socket;
                    joining.join(socketHost, numberOfClients);
                    hostName = joining.hostName(socketHost);
                    host = new Host(hostName, socketHost);
                } else {
                    Socket socketPlayer = socket;
                    joining.join(socket, numberOfClients);
                    playerName = joining.playerName(socket);
                    players.add(new Player(playerID, playerName, 0, socket));
                }

            }




            //> a thread is created for every single client
            //> these threads will handle every in- and outputs from clients
            /*new Thread(
                    new ClientTask(socket, "Multithreaded Server", numberOfClients, inetAddress.getHostAddress())
            ).start();
            System.out.println("Threading done!");*/

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

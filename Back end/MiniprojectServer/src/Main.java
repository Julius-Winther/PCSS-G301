import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]) throws IOException {
        //Creatin an object for the gam
        Game game =  new Game();
        //game.loadQuestions();

        ArrayList<Socket> sockets = new ArrayList<Socket>();
        //Hosting the server
        int port = 8000;
        int numberOfClients = 0;

        ArrayList<String> names = new ArrayList<String>();


        //> this prints out the information (ip and port) that is needed in order for the client(s) to join the server
        ServerSocket server = new ServerSocket(port);
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Ask the dummy client to enter this IP address:\n" + inetAddress.getHostAddress() + "\nand this port number:\n" + port);

        while (true) {
            Socket socket = server.accept();    //accepts clients
            sockets.add(socket);
            DataOutputStream output = new DataOutputStream (socket.getOutputStream());
            if(numberOfClients == 0){
                output.writeBoolean(true); // tells client that they are the host.
            }
            else {
                output.writeBoolean(false); //Game will start
            }

            DataInputStream input = new DataInputStream(socket.getInputStream());
            String name = input.readUTF();
            names.add(name);

            System.out.println("Client name: " + name);

            numberOfClients++;



            if (numberOfClients >= 3){
                boolean lobbyFilled = true;
                break;
            }

            inetAddress = socket.getInetAddress();

            System.out.println("\nClient number " + numberOfClients + " joined!");
            System.out.println("Client " + numberOfClients + "'s host name is: " + inetAddress.getHostName());
            System.out.println("Client " + numberOfClients + "'s IP-address is: " + inetAddress.getHostAddress() + "\n");

            //> a thread is created for every single client
            //> these threads will handle every in- and outputs from clients
           /* new Thread(
                    new ClientTask(socket, "Multithreaded Server", numberOfClients, inetAddress.getHostAddress())
            ).start();
            System.out.println("Threading done!"); */

        }
        for (int i = 0; i < sockets.size(); i++) {
            DataOutputStream output = new DataOutputStream(sockets.get(i).getOutputStream());
            for (int j = 0; j < names.size(); j++) {
                output.writeUTF(names.get(j));
            }
        }
        System.out.println("Sent all the names to the client");

        while(true) {

        }
    }
}
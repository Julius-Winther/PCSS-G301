import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8888;
        ServerSocket server = new ServerSocket(port);
        Socket socket;
        ArrayList<Socket> sockets = new ArrayList<Socket>();
        ArrayList<ClientCommunication> clientCommunications = new ArrayList<ClientCommunication>();

        DataInputStream input;
        DataOutputStream output;

        int numberOfClients = 0;
        int clientID;

        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP-Address:\n" + inetAddress.getHostAddress() + "\nPort:\n" + port);
        while(true) {
            clientID = numberOfClients;
            socket = server.accept();
            sockets.add(socket);

            ClientCommunication clientCommunication = new ClientCommunication(socket, clientID);
            clientCommunications.add(clientCommunication);

            new Thread(clientCommunication).start();
            numberOfClients++;
        }
    }
}
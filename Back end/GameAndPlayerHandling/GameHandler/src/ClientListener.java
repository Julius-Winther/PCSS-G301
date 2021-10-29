import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientListener implements Runnable{
    int port = 9999;
    int clientID = 0;
    ServerSocket server = new ServerSocket(port);
    InetAddress inetAddress = InetAddress.getLocalHost();

    Socket socket;

    DataInputStream input;
    DataOutputStream output;

    PlayerHandler playerHandler;

    public ClientListener(PlayerHandler playerHandler) throws IOException {
        this.playerHandler = playerHandler;
        System.out.println("Server IP: " + inetAddress.getHostAddress() + "\nPort: " + port);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Socket socket = server.accept();
                clientID++;
                //System.out.println("Client joined!");
                input = new DataInputStream(socket.getInputStream());
                //System.out.println("Input stream created");

                //System.out.println("Listening for player name");
                String playerName = input.readUTF();
                //System.out.println("Player name read");
                System.out.println(playerName + " has joined!");

                playerHandler.addSocket(socket);
                //System.out.println("Socket added");

                playerHandler.addPlayer(playerName, 0);
                //System.out.println("New player created");

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Client could not connect");
            }
        }
    }
}

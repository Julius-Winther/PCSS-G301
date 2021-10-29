import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Joining {

    //Sockets
    Socket socket;
    Socket hostSocket;
    Socket playerSocket;

    int numberOfClients;

    Joining(){
    }

    public void hostJoin(Socket socket, int numberOfClients) throws IOException {

        //Setting host socket
        hostSocket = socket;

        InetAddress inetAddress = socket.getInetAddress();
        System.out.println("InetAddress declared!");

        System.out.println("\nClient number " + numberOfClients + " joined!");
        System.out.println("Client " + numberOfClients + "'s host name is: " + inetAddress.getHostName());
        System.out.println("Client " + numberOfClients + "'s IP-address is: " + inetAddress.getHostAddress() + "\n");
    }
    public void playerJoin(Socket socket, int numberOfClients) throws IOException {

        InetAddress inetAddress = socket.getInetAddress();
        System.out.println("InetAddress declared!");

        System.out.println("\nClient number " + numberOfClients + " joined!");
        System.out.println("Client " + numberOfClients + "'s host name is: " + inetAddress.getHostName());
        System.out.println("Client " + numberOfClients + "'s IP-address is: " + inetAddress.getHostAddress() + "\n");
    }

    public String hostName(Socket socket) throws IOException {
        //Creating input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        //Reading the name entered by the host
        String name = input.readUTF();
        output.writeUTF("Welcome " + name + " you are our game host of today!\n");
        return name;
    }

    public String playerName (Socket playerSocket) throws IOException {
        //Creating input and output streams
        DataInputStream input = new DataInputStream(playerSocket.getInputStream());
        DataOutputStream outputPlayer = new DataOutputStream(playerSocket.getOutputStream());
        DataOutputStream outputHost = new DataOutputStream(hostSocket.getOutputStream());

        String name = input.readUTF();
        outputPlayer.writeUTF("Welcome " + name + " you are a player in the game!\n");
        outputPlayer.writeUTF("Wait for host to start game");
        outputHost.writeUTF("A new player by the name: " + name + " just joined the game!\n" + "If you wish to start the game write 'start' and press \n" + "If more player need to join.. Wait");
        return name;
    }

    public void startGame() throws IOException {

    }
}

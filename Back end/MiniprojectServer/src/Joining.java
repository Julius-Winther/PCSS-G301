import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Joining {

    Socket socket;
    int numberOfClients;

    Joining(){
    }

    public void join(Socket socket, int numberOfClients) throws IOException {

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

        String name = input.readUTF();
        output.writeUTF("Welcome " + name + " you are our game host of today!\n" + "If you wish to start the game write 'start' and press enter");
        return name;
    }

    public String playerName (Socket socket) throws IOException {
        //Creating input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String name = input.readUTF();
        output.writeUTF("Welcome " + name + " you are a player in the game!\n" + "Wait for host to start game");
        return name;
    }

    public String startGame() throws IOException {

    }
}

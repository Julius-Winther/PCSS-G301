import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientTask implements Runnable {

    Socket socket = null;
    String serverText = "";
    String ip;
    int clientId;
    Host host;
    ArrayList<Player> players = new ArrayList<Player>();
    volatile String hostName;


    InetAddress inetAddress;

    Scanner scanner = new Scanner(System.in);

    ClientTask(Socket socket, String serverText, int clientId, String ip) {
        this.socket = socket;
        this.serverText = serverText;
        this.clientId = clientId;
        this.ip = ip;
        inetAddress = socket.getInetAddress();
    }

    @Override
    public void run() {
        try {
            //Creating input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            //Host methods
            if (clientId == 1) {
                hostName = input.readUTF();
                host = new Host(hostName);
                System.out.println("This is the name of our host: " + host.getName());
                host.sendHostInfo(output);
            }

            //Client methods
            else {
                String playerName = input.readUTF();
                players.add(new Player(clientId, playerName, 0));
                System.out.println("This " + playerName + " is player number: " + (clientId-1) + " have FUN!");
                players.get(clientId-2).sendPlayerInfo(output, hostName);
            }
        }

         catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some in-/output went wrong!");
        }
    }
}
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        int clientID = 0;

        DataInputStream input;
        DataOutputStream output;

        boolean hasJoinedGame = false;

        Player player = new Player("default", 0, socket, clientID);

        while(true) {
            if(hasJoinedGame) {
                System.out.println("Name: ");

                String name = scanner.next();

                if(!name.equals("")) {
                    output = new DataOutputStream(socket.getOutputStream());
                    output.writeUTF(name);  //name is sent to server

                    input = new DataInputStream(socket.getInputStream());
                    clientID = input.readInt(); //client id is received from server

                    player = new Player(name, 0, socket, clientID); //new player instance
                }
                player.main();
            }
            else {
                String ipAddress = "";
                System.out.println("IP-address:");
                ipAddress = scanner.next();

                int port;
                System.out.println("Port:");
                port = scanner.nextInt();

                socket = new Socket(ipAddress, port);
                hasJoinedGame = true;
            }
        }
    }
}

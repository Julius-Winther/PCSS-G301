import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Jeoparty {
    Socket socket;
    String host;
    int port;
    int clientID;

    boolean hasJoinedServer, isHost, hasJoinedLobby;

    DataInputStream input;
    DataOutputStream output;

    Jeoparty() throws IOException {
        start();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            if(isHost) {
                System.out.println("You are the host");
            }

            if(hasJoinedServer && !hasJoinedLobby) {
                System.out.println("Name:");
                String name = scanner.next();
                if(!name.equals("")) {
                    Player player = new Player(name, 0, clientID);
                    output.writeUTF(name);
                    hasJoinedLobby = true;
                }
            }
            else {
                System.out.println("IP-Address:");
                host = scanner.next();

                System.out.println("Port:");
                port = scanner.nextInt();

                joinServer(host, port);
            }

            if(hasJoinedLobby) {
                if(isHost) {
                    System.out.println("Write 'start' to start the game");
                }
            }
        }
    }

    public void joinServer(String host, int port) throws IOException {
        socket = new Socket(host, port);

        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

        clientID = input.readInt();
        if(clientID == 0) {
            isHost = true;
        }

        hasJoinedServer = true;
    }
}

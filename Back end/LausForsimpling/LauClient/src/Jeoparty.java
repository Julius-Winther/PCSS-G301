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

    boolean hasJoinedServer, isHost, hasJoinedLobby, gameHasStarted;

    DataInputStream input;
    DataOutputStream output;

    Scanner scanner;

    Jeoparty() throws IOException {
        scanner = new Scanner(System.in);

        start();
        game();
    }

    public void start() throws IOException {
        while(true) {
            if(hasJoinedServer && !hasJoinedLobby) {
                System.out.println("Name:");
                String name = scanner.next();
                if(!name.equals("")) {
                    Player player = new Player(name, 0, clientID);
                    System.out.println(player.toString());
                    output.writeUTF(name);
                    hasJoinedLobby = true;
                }
            } //asks the user for a name and then creates a player and notifies the server
            else {
                System.out.println("IP-Address:");
                host = scanner.next();

                System.out.println("Port:");
                port = scanner.nextInt();

                joinServer(host, port);
            } //the user is prompted to provide ip and port for them to join

            if(isHost && !hasJoinedLobby) {
                System.out.println("You are the host");
            } //prints out that you are the host

            if(hasJoinedLobby) {
                if(isHost) {
                    System.out.println("Write 'start' to start the game");
                    if(scanner.next().equals("start")) {
                        output.writeBoolean(true); //host is starting game
                        break;
                    }
                }
                else {
                    System.out.println("Waiting for host to start game...");
                    gameHasStarted = input.readBoolean();
                }
            } //if is host, prompts you accordingly while in the lobby
        }
    }

    public void game() throws IOException {
        System.out.println("Your mom");
        while(true) {
            boolean isYourTurn = input.readBoolean();
            String activePlayerName = input.readUTF();
            if(isYourTurn) {
                System.out.println("It is your turn");
            }
            else {
                System.out.println("It is " + activePlayerName);
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

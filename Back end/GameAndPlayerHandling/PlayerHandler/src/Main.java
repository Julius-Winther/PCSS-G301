import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket;
        Scanner scanner = new Scanner(System.in);

        Game game = new Game(0);

        String name = "";
        int points = 0;
        int clientID = 0;

        DataInputStream input = null;
        DataOutputStream output = null;

        boolean hasJoinedServer = false;
        boolean isHost = false;
        boolean hasGivenName = false;
        boolean gameHasStarted = false;

        while(true) {
            if(gameHasStarted) {
                System.out.println("The game has started!");
                for (int i = 0; i < 25; i++) {
                    System.out.println(input.readUTF());    //questions
                }
                System.out.println(input.readUTF());    //active player
                System.out.println(input.readUTF());    //active question
                if(isHost) {
                    System.out.println("Choose a question by number");
                    output.writeInt(Integer.parseInt(scanner.next()));

                    System.out.println("Write 'done' to exit the question");
                    output.writeBoolean(scanner.next().equals("done"));
                }
            }
            else {
                if(hasJoinedServer) {
                    if(hasGivenName) {
                        if(isHost) {
                            System.out.println("Write 'start' to start the game");
                            boolean hasStartedGame = scanner.next().equals("start");
                            output.writeBoolean(hasStartedGame);
                            gameHasStarted = input.readBoolean();
                        }
                        else {
                            System.out.println("Waiting for host to start game...");
                            gameHasStarted = input.readBoolean();
                        }
                    }
                    else {
                        isHost = input.readBoolean();
                        if(isHost) {
                            System.out.println("You are host");
                        }

                        System.out.println("Name:");
                        name = scanner.next();
                        if(!name.equals("")) {
                            Player player = new Player(name, points, clientID);
                            output.writeUTF(name);
                            hasGivenName = true;
                        }
                    }
                    gameHasStarted = input.readBoolean();
                }
                else {
                    System.out.println("IP-Address:");
                    String ip = scanner.next();

                    System.out.println("Port:");
                    int port = scanner.nextInt();

                    socket = new Socket(ip,port);

                    input = new DataInputStream(socket.getInputStream());
                    output = new DataOutputStream(socket.getOutputStream());

                    //new Thread()

                    hasJoinedServer = true;
                }
            }
        }
    }
}

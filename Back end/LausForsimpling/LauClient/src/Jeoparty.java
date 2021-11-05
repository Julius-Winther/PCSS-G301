import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Jeoparty {
    //> setting up basics
    String host;
    int port;
    Socket socket;
    Scanner scanner = new Scanner(System.in);

    ClientHandler clientHandler;

    boolean isHost = false;
    boolean isJoining = true;
    boolean isLobby, isGame;

    Jeoparty() {    }

    public void update() {
        while(true) {
            if(isJoining) {
                joinServer();
                createClient();
            }

            if(isLobby) {
                waitAndListen();
            }

            if(isGame) {

            }
        }
    }

    public void joinServer() {
        //> input for joining server
        System.out.println("IP-Address:");
        host = scanner.next();
        System.out.println("Port:");
        port = scanner.nextInt();

        //> actually joining server
        try {
            socket = new Socket(host, port);
            clientHandler = new ClientHandler(new Client(false, "Client", 0), socket);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED CONNECTING TO SERVER!");
        }
        System.out.println("Connection success!");
    }

    public void createClient() {
        System.out.println("Your name:");
        String name = scanner.next();
        //> name of this client is sent to server
        try {
            clientHandler.getStringSender().sendString(name);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED SENDING NAME TO SERVER!");
        }

        //> reads isHost from server
        try {
            isHost = clientHandler.getBooleanReceiver().receiveBoolean();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED RECEIVING IS HOST FROM SERVER!");
        }

        //> client object is updated and is host is printed out
        clientHandler.setClient(new Client(isHost, name));
        System.out.println("You are the host: " + isHost);

        isJoining = false;
        isLobby = true;
    }

    public void waitAndListen() {
        //> telling whether someone is already in the lobby
        System.out.println("People in the lobby:");
        while(true) {
            boolean isDoneWithNames = false;
            //> listens for whether we're done going through all clients already joiend
            try {
                isDoneWithNames = clientHandler.getBooleanReceiver().receiveBoolean();
                //System.out.println("Received boolean about unaccounted for clients\nIs done: " + isDoneWithNames);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("FAILED RECEIVING MESSAGE ABOUT GOING THROUGH ALL CLIENTS IN LOBBY!");
            }
            if(isDoneWithNames) {
                break;
            }
            else {
                try {
                    System.out.println(clientHandler.getStringReceiver().receiveString());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("FAILED RECEIVING NAME OF CLIENTS IN LOBBY!");
                }
            } //> the names of clients in the lobby are printed out
        }

        //> prompts the client accordingly
        if(isHost) {
            System.out.println("'start' to begin");
            while(true) {
                boolean willStart = scanner.next().equals("start");
                if(willStart) {
                    //> the server is told that the host will start
                    try {
                        clientHandler.getBooleanSender().sendBoolean(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("FAILED SENDING HOST REQUEST ABOUT STARTING THE GAME!");
                    }
                    break;
                }
            }
        }
        else {
            System.out.println("Wait for host to begin");
        }
    }
}

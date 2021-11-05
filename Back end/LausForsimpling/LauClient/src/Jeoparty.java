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
    boolean isJoining, isLobby, isGame;

    Jeoparty() {
        clientHandler = new ClientHandler(new Client(false, "Client", 0), socket);
    }

    public void update() {
        while(true) {
            if(isJoining) {
                joinServer();
            }

            if(isLobby) {

            }

            if(isGame) {

            }
        }
/*
        //> telling whether someone is already in the lobby
        System.out.println("People in the lobby:");
        while(true) {
            boolean isDoneWithNames = input.readBoolean();
            if(isDoneWithNames) {
                break;
            }
            else {
                System.out.println(input.readUTF());
            }
        }

        //> prompts the client accordingly
        if(isHost) {
            System.out.println("'start' to begin");
        }
        else {
            System.out.println("Wait for host to begin");
        }*/
    }

    public void joinServer() {
        //> joining server
        System.out.println("IP-Address:");
        host = scanner.next();
        System.out.println("Port:");
        port = scanner.nextInt();

        try {
            clientHandler.setSocket(new Socket(host, port));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED CONNECTING TO SERVER!");
        }
        System.out.println("Connection success!");

        createClient();
    }

    public void createClient() {
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
    }
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //> setting up basics
        String host;
        int port;
        Socket socket;
        Scanner scanner = new Scanner(System.in);

        //> joining server
        System.out.println("IP-Address:");
        host = scanner.next();
        System.out.println("Port:");
        port = scanner.nextInt();
        socket = new Socket(host, port);
        System.out.println("Connection success!");

        //> streams for communicating with server
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        //> asking for name
        String name = scanner.next();
        output.writeUTF(name);

        //> telling whether is host
        boolean isHost = input.readBoolean();
        System.out.println("You are the host: " + isHost);

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
        }

    }
}
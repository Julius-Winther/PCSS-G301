import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String host;
        int port;

        Socket socket;

        Scanner scanner = new Scanner(System.in);

        System.out.println("IP-Address:");
        host = scanner.next();
        System.out.println("Port:");
        port = scanner.nextInt();

        socket = new Socket(host, port);
        System.out.println("Connection success!");

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String name = scanner.next();
        output.writeUTF(name);
    }
}
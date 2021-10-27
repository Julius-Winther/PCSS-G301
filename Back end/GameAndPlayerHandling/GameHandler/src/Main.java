import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException {

        int port = 800;
        ServerSocket serverSocket = new ServerSocket();

        while(true) {
            serverSocket.accept();

            System.out.println("Client joined!");
        }
    }
}

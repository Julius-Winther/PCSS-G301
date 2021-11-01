import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AcceptTask implements Runnable {
    int port = 8888;
    int clientID = 0;
    ServerSocket server;
    InetAddress inetAddress;

    Socket socket;
    ArrayList<Socket> sockets = new ArrayList<Socket>();
    ArrayList<ClientTask> clientTasks = new ArrayList<ClientTask>();

    DataInputStream input = null;
    DataOutputStream output = null;

    int numberOfClients = 0;

    @Override
    public void run() {
        try {
            server = new ServerSocket(port);
            inetAddress = InetAddress.getLocalHost();

            System.out.println("Server IP:\n" + inetAddress.getHostAddress() + "\nPort:\n" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while(true) {
                socket = server.accept();
                sockets.add(socket);

                clientTasks.add(new ClientTask(socket, numberOfClients));

                new Thread(clientTasks.get(numberOfClients)).start();

                for (int i = 0; i < sockets.size(); i++) {
                    clientTasks.get(i).notify(clientTasks.get(numberOfClients).getName() + " joined!");
                }

                numberOfClients++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocketFromIndex(int index) {
        return sockets.get(index);
    }
}

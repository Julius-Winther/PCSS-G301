import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientCommunication implements Runnable {
    Socket socket;
    int clientID;

    DataInputStream input;
    DataOutputStream output;

    ClientCommunication(Socket socket, int clientID) throws IOException {
        this.socket = socket;
        this.clientID = clientID;

        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            output.writeInt(clientID);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

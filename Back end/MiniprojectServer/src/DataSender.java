import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class DataSender implements Runnable {
    Socket socket;
    DataOutputStream output;

    DataSender(Socket socket) throws IOException {
        this.socket = socket;
        output = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            sendString("This is a message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendString(String message) throws IOException {
        output.writeUTF(message);
    }
}

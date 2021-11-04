import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class StringSender implements Runnable {
    Socket socket;
    DataOutputStream output;

    public StringSender(Socket socket) throws IOException {
        this.socket = socket;
        output = new DataOutputStream(socket.getOutputStream());
    }

    public void sendString(String message) throws IOException {
        output.writeUTF(message);
    }

    @Override
    public void run() {

    }
}
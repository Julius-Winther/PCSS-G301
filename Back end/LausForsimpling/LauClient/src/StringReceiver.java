import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class StringReceiver implements Runnable {
    Socket socket;
    DataInputStream input;

    public StringReceiver(Socket socket) throws IOException {
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
    }

    public String receiveString() throws IOException {
        return input.readUTF();
    }

    @Override
    public void run() {

    }
}
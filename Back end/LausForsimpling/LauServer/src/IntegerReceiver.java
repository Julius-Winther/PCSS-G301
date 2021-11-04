import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class IntegerReceiver {
    Socket socket;
    DataInputStream input;

    public IntegerReceiver(Socket socket) throws IOException {
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
    }

    public int receiveInteger() throws IOException {
        return input.readInt();
    }
}
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BooleanSender {
    Socket socket;
    DataOutputStream output;

    public BooleanSender(Socket socket) throws IOException {
        this.socket = socket;
        output = new DataOutputStream(socket.getOutputStream());
    }

    public void sendBoolean(boolean bool) throws IOException {
        output.writeBoolean(bool);
    }
}
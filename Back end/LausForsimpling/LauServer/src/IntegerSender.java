import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class IntegerSender {
    Socket socket;
    DataOutputStream output;

    public IntegerSender(Socket socket) throws IOException {
        this.socket = socket;
        output = new DataOutputStream(socket.getOutputStream());
    }

    public void sendInteger(int number) throws IOException {
        output.writeInt(number);
    }
}
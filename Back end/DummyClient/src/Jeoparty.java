import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Jeoparty {
    Socket socket;
    DataOutputStream output;
    DataInputStream input;

    public void joinServer(String host, int port) throws IOException {
        socket = new Socket(host, port);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    public void sendMessage(String message) throws IOException {
        output.writeUTF(message);
    }

    public String getMessage() throws IOException {
        return input.readUTF();
    }

    public void sendNumber(int number) throws IOException {
        output.writeInt(number);
    }

    public int getNumber() throws IOException {
        return input.readInt();
    }

    public void sendBoolean(boolean bool) throws IOException {
        output.writeBoolean(bool);
    }

    public boolean getBoolean() throws IOException {
        return input.readBoolean();
    }
}
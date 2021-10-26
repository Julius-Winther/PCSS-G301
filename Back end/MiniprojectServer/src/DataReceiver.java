import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class DataReceiver implements Runnable {

    Socket socket;
    DataInputStream input;

    DataReceiver(Socket socket) throws IOException {
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            if(!input.readUTF().equals("")) {
                receiveString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some in-/output went wrong!");
        }
    }

    public String receiveString() throws IOException {
        String message = input.readUTF();
        return message;
    }
}
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class AcceptingClientTask implements Runnable {

    Socket socket = null;
    String serverText = "";

    InetAddress inetAddress;

    AcceptingClientTask(Socket socket, String serverText) {
        this.socket = socket;
        this.serverText = serverText;
        inetAddress = socket.getInetAddress();
    }

    @Override
    public void run() {
        //> The loan will be calculated in here
        try {
            //Creating input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some in-/output went wrong!");
        }
    }
}
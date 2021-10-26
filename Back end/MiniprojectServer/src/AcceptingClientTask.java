import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class AcceptingClientTask implements Runnable {

    Socket socket = null;
    String serverText = "";

    Chat chat;

    InetAddress inetAddress;

    Scanner scanner = new Scanner(System.in);

    AcceptingClientTask(Socket socket, Chat chat, String serverText) {
        this.socket = socket;
        this.serverText = serverText;
        this.chat = chat;
        inetAddress = socket.getInetAddress();
    }

    @Override
    public void run() {
        try {
            //Creating input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            while(true) {
                String userInput = input.readUTF();
                if(!userInput.equals("")) {
                    chat.addMessage(userInput);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some in-/output went wrong!");
        }
    }
}
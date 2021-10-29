import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        PlayerHandler playerHandler = new PlayerHandler();

        ClientListener myClientListener = new ClientListener(playerHandler);

        Thread myThread = new Thread(myClientListener);

        myThread.start();

        Scanner scanner = new Scanner(System.in);

        DataInputStream input;
        DataOutputStream output;

        while(true) {
            String serverMessage = scanner.nextLine();
            if(!serverMessage.equals("")) {
                System.out.println("Server said:" + serverMessage);
                for (int i = 0; i < playerHandler.getNumberOfSockets(); i++) {
                    output = new DataOutputStream(playerHandler.getSocketFromIndex(i).getOutputStream());
                    output.writeUTF("Server said: " + serverMessage);
                }
            }
        }
    }
}

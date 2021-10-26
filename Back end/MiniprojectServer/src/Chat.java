import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Chat {
    ArrayList<String> chatMessages = new ArrayList<String>();
    ArrayList<Socket> sockets = new ArrayList<Socket>();

    boolean hasNewMessage;

    public void update() {
        if(hasNewMessage) {
            printMessage();
        }
    }

    public void addMessage(String newMessage) throws IOException {
        chatMessages.add(newMessage);
        System.out.println("new message: " + chatMessages.get(chatMessages.size()-1));

        //> the new message is sent to every socket there is
        for (int i = 0; i < sockets.size(); i++) {
            DataOutputStream output = new DataOutputStream(sockets.get(i).getOutputStream());
            output.writeUTF(chatMessages.get(chatMessages.size()-1));
            System.out.println("wrote message to socket");
        }
    }

    public void addSocket(Socket socket) {
        sockets.add(socket);
    }



    public void printMessage() {
        System.out.println("Printing message...");
    }
}
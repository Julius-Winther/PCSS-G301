import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Announcer {

    public static ArrayList<Socket> sockets = new ArrayList<Socket>();
    public static ArrayList<ClientCommunication> clientCommunications = new ArrayList<ClientCommunication>();

    DataOutputStream output;

    public void notifyAllBoolean(boolean state) {
        for (int i = 1; i < sockets.size(); i++) {
            try {
                output = new DataOutputStream(sockets.get(i).getOutputStream());
                output.writeBoolean(state);
                clientCommunications.get(i).gameHasStarted = state;
                //System.out.println("Notified " + state + " to " + sockets.get(i).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class PlayerHandler {
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Socket> sockets = new ArrayList<Socket>();

    DataInputStream input;
    DataOutputStream output;

    PlayerHandler() {

    }

    public void addPlayer(String name, int points) throws IOException {
        players.add(new Player(name, points));

        String message = name + " has joined!";
        notifyAllPlayers(message);
    }

    public void removePlayerWithIndex(int index) {
        players.remove(index);
    }

    public void printPlayers() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + ": " + players.get(i).getPoints());
        }
    }

    public void notifyAllPlayers(String message) throws IOException {
        for (int i = 0; i < sockets.size(); i++) {
            output = new DataOutputStream(sockets.get(i).getOutputStream());
            output.writeUTF(message);
        }
    }

    public void addSocket(Socket socket) {
        sockets.add(socket);
    }

    public Socket getSocketFromIndex(int index) {
        return sockets.get(index);
    }

    public int getNumberOfSockets() {
        return sockets.size();
    }
}

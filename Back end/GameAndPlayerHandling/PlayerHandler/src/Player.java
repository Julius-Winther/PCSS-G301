import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Player {
    String name;
    int points;
    int clientID;
    boolean gameHasStarted = false;

    Socket socket;

    DataInputStream input;
    DataOutputStream output;

    Player(String name, int points, Socket socket, int clientID) {
        this.name = name;
        this.points = points;
        this.socket = socket;
        this.clientID = clientID;
    }

    public void main() throws IOException { //for now, all things will happen from within here, when the player has joined
        System.out.println("You're in game!");
        input = new DataInputStream(socket.getInputStream());   //listens to server
        while(true) {
            System.out.println(input.readUTF());    //prints out any string send from the server
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int pointsToAdd) {
        points += pointsToAdd;
    }

    public void subtractPoints(int pointsToSubtract) {
        points -= pointsToSubtract;
    }
}

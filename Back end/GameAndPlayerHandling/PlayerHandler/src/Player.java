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

    Player(String name, int points, int clientID) {
        this.name = name;
        this.points = points;
        this.clientID = clientID;
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

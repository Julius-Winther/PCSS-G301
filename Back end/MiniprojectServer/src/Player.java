import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Player {

    int playerId;
    String name;
    int points;
    boolean isActive;
    Socket socket;

    //Constructor of player
    public Player(int playerId, String name, int points, Socket socket) {
        this.playerId = playerId;
        this.name = name;
        this.points = points;
        this.socket = socket;
    }

    //Data output from Server to Player
    public void sendPlayerInfo(DataOutputStream output, String hostName) throws IOException {
        output.writeUTF("You are player number: " + playerId + "Have fun!\n" + "This is the name of you awesome host: " + hostName);

    }


    //Getters and Setters for the variables
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

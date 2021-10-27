import java.net.Socket;

public class Player {

    int playerId;
    String name;
    int points;
    boolean isActive;

    //Constructor of player
    public Player(int playerId, String name, int points) {
        this.playerId = playerId;
        this.name = name;
        this.points = points;
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
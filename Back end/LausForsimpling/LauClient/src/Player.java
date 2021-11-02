public class Player {
    String name;
    int points;
    int clientID;

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

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String toString() {
        return name + ":\nPoints: " + points + "\nClient ID: " + clientID;
    }
}

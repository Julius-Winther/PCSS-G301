import java.net.Socket;
import java.util.ArrayList;

public class PlayerHandler {
    ArrayList<Player> players = new ArrayList<Player>();

    //Method for adding player to player array
    public void addPlayer(int playerId, String name, int points, Socket socket) {
        players.add(new Player(playerId, name, points, socket));
    }

    //Method for getting specific player object from playerID
    public Player getPlayer(int playerID) {
        return players.get(playerID);
    }

}

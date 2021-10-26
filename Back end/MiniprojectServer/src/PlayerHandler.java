import java.net.Socket;
import java.util.ArrayList;

public class PlayerHandler {
    ArrayList<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int playerID) {
        return players.get(playerID);
    }

}

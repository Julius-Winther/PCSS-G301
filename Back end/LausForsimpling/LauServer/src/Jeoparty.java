import java.net.Socket;
import java.util.ArrayList;

public class Jeoparty {
    ArrayList<Socket> sockets = new ArrayList<Socket>();

    boolean isLobby;
    boolean isGame;

    public Jeoparty() {
    }

    public Jeoparty(ArrayList<Socket> sockets) {
        this.sockets = sockets;
    }

    public Jeoparty(ArrayList<Socket> sockets, boolean isLobby, boolean isGame) {
        this.sockets = sockets;
        this.isLobby = isLobby;
        this.isGame = isGame;
    }

    public ArrayList<Socket> getSockets() {
        return sockets;
    }

    public void setSockets(ArrayList<Socket> sockets) {
        this.sockets = sockets;
    }

    public void addSocket(Socket socket) {
        sockets.add(socket);
    }

    public void removeSocketByIndex(int index) {
        sockets.remove(index);
    }

    public boolean isLobby() {
        return isLobby;
    }

    public void setLobby(boolean lobby) {
        isLobby = lobby;
    }

    public boolean isGame() {
        return isGame;
    }

    public void setGame(boolean game) {
        isGame = game;
    }

    @Override
    public String toString() {
        return "Jeoparty{" +
                "sockets=" + sockets +
                ", isLobby=" + isLobby +
                ", isGame=" + isGame +
                '}';
    }
}

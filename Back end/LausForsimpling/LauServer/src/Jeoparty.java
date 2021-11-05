import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Jeoparty implements Runnable {
    int port = 8888;
    ServerSocket server;
    Socket socket;

    ArrayList<ClientHandler> clientHandlers = new ArrayList<ClientHandler>();
    ArrayList<Socket> sockets = new ArrayList<Socket>();

    boolean isLobby = true;
    boolean isGame;

    int numberOfClients = 0;

    public Jeoparty() throws IOException {
        server = new ServerSocket(port);
    }

    public Jeoparty(boolean isLobby, boolean isGame) throws IOException {
        server = new ServerSocket(port);

        this.isLobby = isLobby;
        this.isGame = isGame;
    }


    @Override
    public void run() {
        try {
            update();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("FAILED RUNNING UPDATE()-METHOD!");
        }
    }

    public void update() throws UnknownHostException {
        while(true) {
            if(isLobby) {

            }

            if(isGame) {

            }
        }
    }

    public ArrayList<ClientHandler> getClientHandlers() {
        return clientHandlers;
    }

    public void setClients(ArrayList<ClientHandler> clientHandlers) {
        this.clientHandlers = clientHandlers;
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
                ", isLobby=" + isLobby +
                ", isGame=" + isGame +
                '}';
    }
}
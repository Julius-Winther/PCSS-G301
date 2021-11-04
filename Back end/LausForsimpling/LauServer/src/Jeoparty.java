import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Jeoparty {
    int port = 8888;
    ServerSocket server;

    ArrayList<Client> clients;
    ArrayList<Socket> sockets;

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

    public void update() {
        while(true) {
            if(isLobby) {
                listenForClients();
            }

            if(isGame) {

            }
        }
    }

    void listenForClients() {
        try {
            Socket socket = server.accept();
            System.out.println("Someone joined!");
            sockets.add(socket);

            new Thread(new ClientHandler(socket)).start();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CLIENT FAILED CONNECTING TO SERVER!");
        }
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Socket> getSockets() {
        return sockets;
    }

    public void setSockets(ArrayList<Socket> sockets) {
        this.sockets = sockets;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClientByIndex(int index) {
        clients.remove(index);
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

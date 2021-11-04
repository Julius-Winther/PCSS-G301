import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Jeoparty {
    int port = 8888;
    ServerSocket server;
    Socket socket;

    InetAddress inetAddress;

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

    public void update() throws UnknownHostException {
        inetAddress = InetAddress.getLocalHost();
        System.out.println("IP-Address:\n" + inetAddress.getHostAddress() + "\nPort:\n" + port);

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
            socket = server.accept();
            //System.out.println("Someone joined!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CLIENT FAILED CONNECTING TO SERVER!");
        }

        boolean isHost = numberOfClients == 0;

        ClientHandler clientHandler = new ClientHandler(socket);
        clientHandlers.add(clientHandler);
        new Thread(clientHandler).start();

        try {
            //clientHandler.getClient().setName(clientHandler.getStringReceiver().receiveString());
            clientHandler.setClient(new Client(isHost, clientHandler.getStringReceiver().receiveString(), numberOfClients));
            System.out.println(clientHandler.getClient().toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED SETTING CLIENT NAME!");
        }

        numberOfClients++;
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

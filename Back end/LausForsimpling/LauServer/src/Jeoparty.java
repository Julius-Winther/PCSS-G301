import java.io.DataOutputStream;
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
        //> the listening
        try {
            socket = server.accept();
            //System.out.println("Someone joined!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CLIENT FAILED CONNECTING TO SERVER!");
        }

        boolean isHost = numberOfClients == 0; //used for deciding who is host

        //> client handler is created with default client, started in another thread and added to the arraylist of client handlers
        ClientHandler clientHandler = new ClientHandler(socket); //an object for handling clients and their socket
        clientHandlers.add(clientHandler);
        new Thread(clientHandler).start();

        //> the client is assigned some proper values, e.g. by using the stringReceiver which listens for strings (name) from the client
        try {
            clientHandler.setClient(new Client(isHost, clientHandler.getStringReceiver().receiveString(), numberOfClients));
            System.out.println(clientHandler.getClient().toString() + " joined");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED SETTING UP CLIENT!");
        }

        //> the client is told whether it is the host or not
        try {
            clientHandler.getBooleanSender().sendBoolean(isHost);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED SENDING HOST CONFIRMATION TO CLIENT 0!");
        }

        //> notifying the current client about who is currently in the lobby
        for (int i = 0; i < clientHandlers.size(); i++) {
            //> telling the current client that all former clients have been accounted for
            try {
                clientHandler.getBooleanSender().sendBoolean(false);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("FAILED TELLING THE CLIENT THAT THERE ARE STILL OTHER CLIENTS TO ACCOUNT FOR!");
            }

            //> the names of other clients are sent to the current client
            try {
                if(i != numberOfClients) //makes sure that the current client is not told about their own entrance
                    clientHandler.getStringSender().sendString(clientHandlers.get(i).getClient().getName());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("FAILED TELLING THE NEW CLIENT ABOUT CLIENTS THAT HAVE ALREADY JOINED!");
            }
        }

        //> telling the current client that all former clients have been accounted for
        try {
            if(numberOfClients == 0) {
                clientHandler.getStringSender().sendString("No one..");
            }
            clientHandler.getBooleanSender().sendBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED TELLING THE CLIENT THAT ALL OTHER CLIENTS ARE ACCOUNTED FOR!");
        }

        //> all clients are notified that someone joined
        try {
            for (int i = 0; i < clientHandlers.size(); i++) {
                //if(i != numberOfClients) {
                    clientHandlers.get(i).getStringSender().sendString(clientHandler.getClient().getName());
                //}
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED NOTIFYING CLIENTS ABOUT NEW CLIENT");
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
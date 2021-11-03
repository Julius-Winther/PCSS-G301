import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientCommunication implements Runnable {
    Socket socket;
    int clientID;
    String clientName;
    int clientPoints = 0;

    public boolean gameHasStarted;

    DataInputStream input;
    DataOutputStream output;

    public Announcer announcer;

    ClientCommunication(Socket socket, int clientID, Announcer announcer) throws IOException {
        this.socket = socket;
        this.clientID = clientID;

        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

        this.announcer = announcer;
    }

    @Override
    public void run() {
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(clientID != 0) {
                while(true) {
                    if(gameHasStarted) {
                        output.writeBoolean(true);
                        break;
                    }
                    //System.out.println(clientName + " cheking whether game has started");
                }
            }
            game();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start() throws IOException {
        output.writeInt(clientID);
        clientName = input.readUTF();
        System.out.println(clientName + " joined!");

        if(clientID == 0) {
            System.out.println(clientName + " is the host");
            gameHasStarted = input.readBoolean();
            announcer.notifyAllBoolean(gameHasStarted);
            System.out.println("Read gameHasStarted from host " + clientName);
        }
        else {
            System.out.println(clientName + " is a client");
            while(true) {
                if(gameHasStarted) {
                    break;
                }
            }
        }
    }

    public void game() throws IOException {
        System.out.println(clientName + " says: I'm in-game");
        while(true) {

        }
    }
}
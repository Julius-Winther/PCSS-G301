import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    Client client;
    ArrayList<ClientHandler> clientHandlers = new ArrayList<ClientHandler>();
    Socket socket;

    BooleanReceiver booleanReceiver;
    BooleanSender booleanSender;

    IntegerReceiver integerReceiver;
    IntegerSender integerSender;

    StringReceiver stringReceiver;
    StringSender stringSender;

    public ClientHandler(Socket socket) {
        client = new Client(false, "Client", 0);
        this.socket = socket;

        try {
            booleanReceiver = new BooleanReceiver(socket);
            booleanSender = new BooleanSender(socket);

            integerReceiver = new IntegerReceiver(socket);
            integerSender = new IntegerSender(socket);

            stringReceiver = new StringReceiver(socket);
            stringSender = new StringSender(socket);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED TO CREATE RECEIVERS AND SENDERS!");
        }
    }

    public ClientHandler(Client client, Socket socket) {
        this.client = client;
        this.socket = socket;

        try {
            booleanReceiver = new BooleanReceiver(socket);
            booleanSender = new BooleanSender(socket);

            integerReceiver = new IntegerReceiver(socket);
            integerSender = new IntegerSender(socket);

            stringReceiver = new StringReceiver(socket);
            stringSender = new StringSender(socket);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED TO CREATE RECEIVERS AND SENDERS!");
        }
    }

    @Override
    public void run() {
        new Thread(booleanReceiver).start();
        new Thread(booleanSender).start();

        new Thread(integerReceiver).start();
        new Thread(integerSender).start();

        new Thread(stringReceiver).start();
        new Thread(stringSender).start();

        update();
    }

    public void update() {
        listenForOtherClients();
    }

    public void listenForOtherClients() {
        //> notifying the current client about who is currently in the lobby
        //> telling the current client that all former clients have been accounted for
        try {
            getBooleanSender().sendBoolean(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED TELLING THE CLIENT THAT THERE ARE STILL OTHER CLIENTS TO ACCOUNT FOR!");
        }

        //> the names of other clients are sent to the current client
        for(int i = 0; i < clientHandlers.size(); i++) {
            try {
                if(i != clientHandlers.size()-1) //makes sure that the current client is not told about their own entrance
                    getStringSender().sendString(clientHandlers.get(i).getClient().getName());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("FAILED TELLING THE NEW CLIENT ABOUT CLIENTS THAT HAVE ALREADY JOINED!");
            }
        }
        //System.out.println("Done going through all clients in lobby");

        //> telling the current client that all former clients have been accounted for
        try {
            if(clientHandlers.size()-1 == 0) {
                getStringSender().sendString("You're the only one yet..");
            }
            for (int i = 0; i < clientHandlers.size(); i++) {
                clientHandlers.get(i).getBooleanSender().sendBoolean(true);
            }
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
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BooleanReceiver getBooleanReceiver() {
        return booleanReceiver;
    }

    public void setBooleanReceiver(BooleanReceiver booleanReceiver) {
        this.booleanReceiver = booleanReceiver;
    }

    public BooleanSender getBooleanSender() {
        return booleanSender;
    }

    public void setBooleanSender(BooleanSender booleanSender) {
        this.booleanSender = booleanSender;
    }

    public IntegerReceiver getIntegerReceiver() {
        return integerReceiver;
    }

    public void setIntegerReceiver(IntegerReceiver integerReceiver) {
        this.integerReceiver = integerReceiver;
    }

    public IntegerSender getIntegerSender() {
        return integerSender;
    }

    public void setIntegerSender(IntegerSender integerSender) {
        this.integerSender = integerSender;
    }

    public StringReceiver getStringReceiver() {
        return stringReceiver;
    }

    public void setStringReceiver(StringReceiver stringReceiver) {
        this.stringReceiver = stringReceiver;
    }

    public StringSender getStringSender() {
        return stringSender;
    }

    public void setStringSender(StringSender stringSender) {
        this.stringSender = stringSender;
    }
}
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    Client client;
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
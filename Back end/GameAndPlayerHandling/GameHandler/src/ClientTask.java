import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientTask implements Runnable {
    Socket socket;
    boolean gameHasStarted;

    DataInputStream input;
    DataOutputStream output;

    String name = "";
    int points = 0;
    int clientID;

    int maxNumberOfPlayers = 5;
    int activePlayerID = 0;

    /*String[] questions = {"q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9", "q10"
            , "q11", "q12", "q13", "q14", "q15", "q16", "q17", "q18", "q19", "q20"
            , "q21", "q22", "q23", "q24", "q25"};*/
    ArrayList<String> questions = new ArrayList<String>();
    int activeQuestionIndex;

    ClientTask(Socket socket, int clientID) {
        this.socket = socket;
        this.clientID = clientID;

        for (int i = 0; i < 25; i++) {
            questions.add("question #" + (i+1));
        }

        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            output.writeBoolean(clientID == 0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not send host boolean to client");
        }

        try {
            name = input.readUTF();
            System.out.println(name + " joined!");
            while(!gameHasStarted) {
                gameHasStarted = input.readBoolean();
                output.writeBoolean(gameHasStarted);
                System.out.println("Waiting for host to start the game...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(gameHasStarted) {
            /*try {
                output.writeInt(activePlayerID);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            System.out.println("The game has started!");
            for(int i = 0; i < questions.size(); i++) {
                System.out.println(questions.get(i));
                try {
                    output.writeUTF(questions.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("Player " + (activePlayerID+1) + "'s turn");
                output.writeUTF("Player " + (activePlayerID+1) + "'s turn");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(clientID == 0) {
                try {
                    activeQuestionIndex = input.readInt();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Question:\n" + questions.get(activeQuestionIndex));
            try {
                output.writeUTF("Question:\n" + questions.get(activeQuestionIndex));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("Waiting for host to exit question");
                input.readBoolean();
            } catch (IOException e) {
                e.printStackTrace();
            }

            activePlayerID++;
            if(activePlayerID >= maxNumberOfPlayers) {
                activePlayerID = 0;
            }
        }
    }

    public void notify(String message) throws IOException {
        output.writeUTF(message);
    }

    public String getName() {
        return name;
    }
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Jeoparty {
    ArrayList<Socket> sockets = new ArrayList<Socket>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> questionTitles = new ArrayList<String>();
    ArrayList<String> questionAnswers = new ArrayList<String>();

    int port = 8000;
    int numberOfClients = 0;
    ServerSocket server;
    Socket socket;

    public Jeoparty() {
        addQuestions();
        addAnswers();
    }

    public void update() {
        while(true) {
            startServer();
            listenForClients();
            writeOutNames();
            writeOutQuestionsAndAnswers();
        }
    }

    void addQuestions() {
        questionTitles.add("This game has you stacking blocks in different shapes,\ntrying to rack up as many points without reaching the top");
        questionTitles.add("This action RPG has been released and re-released\nin almost every format over the last 10 years.");
        questionTitles.add("This game features player-made game modes such as\nProp Hunt, Trouble in Terrorist Town and Hide and Seek.");
        questionTitles.add("The game series in which Nuclear Gandhi originates from.");
        questionTitles.add("The original LEGO Star Wars, God Of War and the\nXbox 360 were released this year.");

        questionTitles.add("This animal is the most globally popular house pet.");
        questionTitles.add("");
        questionTitles.add("");
        questionTitles.add("");
        questionTitles.add("");

        questionTitles.add("");
        questionTitles.add("");
        questionTitles.add("");
        questionTitles.add("");
        questionTitles.add("");
    }

    void addAnswers() {
        questionAnswers.add("What is Tetris?");
        questionAnswers.add("What is The Elder Scrolls 5: Skyrim?");
        questionAnswers.add("What is Garry’s mod?");
        questionAnswers.add("What is Civilization?");
        questionAnswers.add("What is 2005?");
    }

    void startServer() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("FAILED SETTING UP INET ADDRESS!");
        }
        //> this prints out the information (ip and port) that is needed in order for the client(s) to join the server
        System.out.println("Ask the dummy client to enter this IP address:\n" + inetAddress.getHostAddress() + "\nand this port number:\n" + port);
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED STARTING SERVER AT THE GIVEN PORT: " + port + "!");
        }
    }

    void listenForClients() {
        while(true) {
            try {
                socket = server.accept();    //accepts clients
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("FAILED ACCEPTING CLIENT!");
            }
            sockets.add(socket);

            try {
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                if (numberOfClients == 0) {
                    output.writeBoolean(true); // tells client that they are the host.
                } else {
                    output.writeBoolean(false); //Game will start
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("FAILED SETTING UP THE OUTPUT STREAM AND WRITING 'START GAME'!");
            }

            try{
                DataInputStream input = new DataInputStream(socket.getInputStream());
                String name = input.readUTF();
                names.add(name);
            } catch(IOException e) {
                e.printStackTrace();
                System.out.println("FAILED SETTING UP THE INPUT STREAM AND READING 'NAME'!");
            }

            System.out.println(names.get(numberOfClients) + " joined!");
            System.out.println("Client number " + numberOfClients);
            //System.out.println("Client " + numberOfClients + "'s host name is: " + inetAddress.getHostName());
            //System.out.println("Client " + numberOfClients + "'s IP-address is: " + inetAddress.getHostAddress() + "\n");

            numberOfClients++;

            if (numberOfClients >= 3){
                boolean lobbyFilled = true;
                break;
            }
        }
    }

    void writeOutNames() {
        for (int i = 0; i < 1; i++) {
            DataOutputStream output = null;
            try {
                output = new DataOutputStream(sockets.get(i).getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("FAILED SETTING UP OUTPUT STREAM FOR WRITING NAMES!");
            }
            for (int j = 0; j < names.size(); j++) {
                try {
                    output.writeUTF(names.get(j));
                    System.out.println("Name " + names.get(j) + " sent!");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("FAILED WRITING NAME!");
                }
            }
        }
    }

    void writeOutQuestionsAndAnswers() {
        DataInputStream hostInput;
        try {
            hostInput = new DataInputStream(sockets.get(0).getInputStream());

            int questionsLeft = 5;
            while(questionsLeft >= 1) {
                int activeQuestionNumber = hostInput.readInt();
                String activeQuestion = questionTitles.get(activeQuestionNumber);
                String questionAnswer = questionAnswers.get(activeQuestionNumber);

                System.out.println("The active question index: " + activeQuestionNumber);
                System.out.println("The question is: " + activeQuestion);

                for (int i = 0; i < sockets.size(); i++) {
                    DataOutputStream output = new DataOutputStream(sockets.get(i).getOutputStream());
                    output.writeUTF(activeQuestion);
                    System.out.println("Active question: " + activeQuestion);
                    System.out.println("Question answer: " + questionAnswer);
                    if(i == 0) {
                        output.writeUTF(questionAnswer);
                    }
                }

                System.out.println("done with this question");
                questionsLeft--;
                System.out.println("Questions left: " + questionsLeft);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FAILED SETTING UP AND RECEIVING HOST INPUT!");
        }
    }
}
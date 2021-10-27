import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Jeoparty jeoparty = new Jeoparty(); //custom class, representing the application instance

        Scanner scanner = new Scanner (System.in);  //handles input

        boolean hasJoinedHost = false;  //whether this client has joined the server or not

        while(true) {
            //> if this client has joined,
            if (hasJoinedHost){
                System.out.println("Give me name"); //prompt to provide name
                String userInput = scanner.next();

                if(!userInput.equals("")) { //only if the user sents something that is NOT blank space, the following
                    // lines will be executed
                    jeoparty.sendMessage(userInput);    //the name is sent to the server
                }
            }
            //> if this client has not joined
            else {
                //> prompt and input
                System.out.println("Write start to join the server");
                String userInput = scanner.next();

                //> if the user writes "start"
                if(userInput.equals("start")) {
                    System.out.println("Write IP-Address: ");   //prompt to provide IP-address
                    String hostInput = scanner.next();
                    System.out.println("Write Port: "); //prompt to provide port
                    String portInput = scanner.next();
                    jeoparty.joinServer(hostInput, Integer.parseInt(portInput));    //joins server, using the jeoparty
                    // class' function .joinServer()
                    hasJoinedHost = true;   //now the client has joined, and the relevant boolean is set to true
                }
            }
        }
    }
}
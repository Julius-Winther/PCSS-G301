import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        GameInstance gameInstance = new GameInstance();

        Scanner scanner = new Scanner (System.in);

        while(true) {
            System.out.println("Write start to join the server");
            String userInput = scanner.next();
            System.out.println(userInput);

            if(userInput.equals("start")) {
                System.out.println("Write IP-Address: ");
                String hostInput = scanner.next();
                System.out.println("Write Port: ");
                String portInput = scanner.next();
                gameInstance.joinServer(hostInput, Integer.parseInt(portInput));
            }
        }

    }
}
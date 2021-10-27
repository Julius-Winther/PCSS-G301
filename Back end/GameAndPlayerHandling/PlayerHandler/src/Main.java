import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket;
        Scanner scanner = new Scanner(System.in);

        boolean hasJoinedGame = false;

        Player player = new Player("default", 0);

        while(true) {
            if(hasJoinedGame) {
                System.out.println("Name: ");

                String name = scanner.next();

                if(!name.equals("")) {
                    player = new Player(name, 0);
                }
                player.main();
            }
            else {
                String ipAddress = "";
                System.out.println("IP-address:");

                ipAddress += scanner.nextLine();
                scanner.close();

                int port;
                System.out.println("Port:");

                port = scanner.nextInt();
                scanner.close();

                socket = new Socket(ipAddress, port);
                hasJoinedGame = true;
            }
        }
    }
}

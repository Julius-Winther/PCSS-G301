import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        PlayerHandler playerHandler = new PlayerHandler();

        new Thread(
                new ClientListener(playerHandler)
        ).start();
    }
}

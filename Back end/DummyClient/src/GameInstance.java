import java.io.IOException;
import java.net.Socket;

public class GameInstance {
 //hehe
    public void joinServer(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
    }
}

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    static Jeoparty jeoparty;
    public static void main(String args[]) throws IOException {
        jeoparty = new Jeoparty();
        jeoparty.update();
    }
}
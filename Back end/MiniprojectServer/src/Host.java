import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Host {
    public String name;
    public String ip;
    boolean isCorrect;
    int points;
    DataInputStream input;
    DataOutputStream output;
    Socket socket;

    public Host(String name, Socket socket, String ip) {
        this.name = name;
        this.ip = ip;
        this.socket = socket;
    }

    //Host functions

    //Data output to Server to Host
    public void sendHostInfo(DataOutputStream output) throws IOException {
        output.writeUTF("You are the Host of this game. Be gentle!");
    }




   /* public int chooseCorrect(int points, boolean isCorrect) {
        this.points = points;
        if (isCorrect = false) {
            points = -1*points;
        }
        return points;
    }*/


//Getters and Setters
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

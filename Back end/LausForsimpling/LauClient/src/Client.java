public class Client {
    boolean isHost;
    String name;
    int id;

    public Client() {
        isHost = false;
        name = "Client";
        id = 0;
    }

    public Client(boolean isHost, String name, int id) {
        this.isHost = isHost;
        this.name = name;
        this.id = id;
    }

    public boolean isHost() {
        return isHost;
    }

    public void setHost(boolean host) {
        isHost = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "isHost=" + isHost +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
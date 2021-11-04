public class Player {
    String name;
    int points;
    int id;
    boolean isActive;

    public Player() {
    }

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Player(String name, int points, int id, boolean isActive) {
        this.name = name;
        this.points = points;
        this.id = id;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", id=" + id +
                ", isActive=" + isActive +
                '}';
    }
}
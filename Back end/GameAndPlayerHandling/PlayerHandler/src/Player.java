public class Player {
    String name;
    int points;

    Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public void main() {

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

    public void addPoints(int pointsToAdd) {
        points += pointsToAdd;
    }

    public void subtractPoints(int pointsToSubtract) {
        points -= pointsToSubtract;
    }
}

import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private List<Prize> prizesWon;
    private int totalSpent;

    public Player(String name) {
        this.name = name;
        this.prizesWon = new ArrayList<>();
        this.totalSpent = 0;
    }

    public String getName() {
        return name;
    }

    public List<Prize> getPrizesWon() {
        return prizesWon;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void addPrize(Prize prize) {
        prizesWon.add(prize);
    }

    public void increaseTotalSpent(int amount) {
        totalSpent += amount;
    }
}
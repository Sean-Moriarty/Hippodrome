import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome() {}

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run() {
        try {
            for (int i = 0; i < 100; i++) {
                move();
                print();
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            
        }
    }

    void move() {
        for (Horse h : horses)
            h.move();
    }

    void print() {
        for (Horse h : horses)
            h.print();
        for (int i = 0; i < 10; i++)
            System.out.println();
    }

    public Horse getWinner() {
        Collections.sort(horses, Comparator.comparing(Horse::getDistance));
        Horse winner = horses.get(horses.size() - 1);
        return winner;
    }

    public void printWinner() {
        System.out.println("The winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        game.horses = new ArrayList<>();
        game.horses.add(new Horse("Barbaro", 3, 0));
        game.horses.add(new Horse("Seabiscuit", 3, 0));
        game.horses.add(new Horse("Secretariat", 3, 0));
        game.run();
        game.getWinner();
        game.printWinner();
    }
}

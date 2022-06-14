package _9_objectorienteddesign.example8_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class Automator {
    private Player[] players;
    private Player lastPlayer = null;
    private static Automator instance;
    public ArrayList<Location> remainingMoves = new ArrayList<>();

    private Automator() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Location loc = new Location(i, j);
                remainingMoves.add(loc);
            }
        }
    }

    public static Automator getInstance() {
        if (instance == null) {
            instance = new Automator();
        }
        return instance;
    }

    public void initialize(Player[] ps) {
        players = ps;
        lastPlayer = players[1];
    }

    public void printScores() {
        System.out.println(
                "Score: " + players[0].getColor().toString() + ": " + players[0].getScore() + ", " + players[1]
                        .getColor().toString() + ": " + players[1].getScore());
    }
}

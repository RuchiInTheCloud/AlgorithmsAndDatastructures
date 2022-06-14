package _9_objectorienteddesign.example8_1;

import _3_arraysandstrings.datastructures.ArrayList;

import java.util.Random;

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

        int middleRow = (9) / 2;
        int middleColumn = (9) / 2;
        removeLocation(middleRow, middleColumn);
        removeLocation(middleRow + 1, middleColumn + 1);
        removeLocation(middleRow + 1, middleColumn);
        removeLocation(middleRow, middleColumn + 1);
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < remainingMoves.size(); i++) {
            int t = random.nextInt(remainingMoves.size());
            Location other = remainingMoves.get(t);
            Location current = remainingMoves.get(i);
            remainingMoves.set(t, current);
            remainingMoves.set(i, other);
        }
    }

    public void removeLocation(int r, int c) {
        for (int i = 0; i < remainingMoves.size(); i++) {
            Location loc = remainingMoves.get(i);
            if (loc.isSameAs(r, c)) {
                remainingMoves.remove(i);
            }
        }
    }

    public boolean playRandom() {
        Board board = Game.getInstance().getBoard();
        shuffle();
        lastPlayer = lastPlayer == players[0] ? players[1] : players[0];
        String color = lastPlayer.getColor().toString();
        for (int i = 0; i < remainingMoves.size(); i++) {
            Location loc = remainingMoves.get(i);
            boolean success = lastPlayer.playPiece(loc.getRow(), loc.getColumn());

            if (success) {
                remainingMoves.remove(i);
                System.out.println(
                        "Success: " + color + " move at (" + loc.getRow() + ", " + loc.getColumn()
                                + ")");
                board.printBoard();
                printScores();
                return true;
            }
        }

        System.out.println("Game over. No moves found for " + color);
        return false;
    }

    public boolean isOver() {
        if (players[0].getScore() == 0 || players[1].getScore() == 0) {
            return true;
        }
        return false;
    }

    public void printScores() {
        System.out.println(
                "Score: " + players[0].getColor().toString() + ": " + players[0].getScore() + ", " + players[1]
                        .getColor().toString() + ": " + players[1].getScore());
    }
}

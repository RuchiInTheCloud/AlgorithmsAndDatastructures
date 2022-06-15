package _9_objectorienteddesign.example10_1;

import java.util.Scanner;

public class Game {
    private Board board;
    private GameState state;

    public Game(int rows, int columns, int bombs) {
        board = new Board(rows, columns, bombs);
        board.printBoard(true);
        state = GameState.RUNNING;
    }

    public boolean playGame() {
        Scanner scanner = new Scanner(System.in);
        printGameState();

        while (state == GameState.RUNNING) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                scanner.close();
                return false;
            }

            UserPlay play = UserPlay.fromString(input);
            if (play == null) {
                continue;
            }
            UserPlayResult result = board.playFlip(play);
            if (result.successfulMove()) {
                state = result.getResultingState();
            } else {
                System.out.println("Could not flip cell (" + play.getRow() + "," + play.getColumn() + ").");
            }
            printGameState();
        }
        scanner.close();
        return true;
    }

    public void printGameState() {
        if (state == GameState.LOST) {
            board.printBoard(true);
            System.out.println("FAIL");
        } else if (state == GameState.WON) {
            board.printBoard(true);
            System.out.println("WIN");
        } else {
            System.out.println("Number remaining: " + board.getNumRemaining());
            board.printBoard(false);
        }
    }
}

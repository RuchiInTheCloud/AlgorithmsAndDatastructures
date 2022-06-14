package _9_objectorienteddesign.example8_1;

public class Question {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.getBoard().initialize();
        game.getBoard().printBoard();
        Automator automator = Automator.getInstance();
        automator.playRandom();
        automator.printScores();
    }
}

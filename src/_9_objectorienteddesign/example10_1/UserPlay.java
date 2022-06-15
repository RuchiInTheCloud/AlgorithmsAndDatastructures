package _9_objectorienteddesign.example10_1;

public class UserPlay {
    private int row;
    private int column;
    private boolean isGuess;

    private UserPlay(int row, int column, boolean isGuess) {
        this.row = row;
        this.column = column;
        this.isGuess = isGuess;
    }

    public static UserPlay fromString(String input) {
        boolean isGuess = false;

        if (input.length() > 0 && input.charAt(0) == 'B') {
            isGuess = true;
            input = input.substring(1);
        }
        if (!input.matches("\\d* \\d+")) {
            return null;
        }

        String[] parts = input.split(" ");
        try {
            int row = Integer.parseInt(parts[0]);
            int column = Integer.parseInt(parts[1]);
            return new UserPlay(row, column, isGuess);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isGuess() {
        return isGuess;
    }
}

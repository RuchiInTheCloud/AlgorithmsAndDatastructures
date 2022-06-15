package _9_objectorienteddesign.example10_1;

import _4_linkedlists.datastructures.LinkedList;

import java.util.Random;

public class Board {
    private int nRows;
    private int nColumns;
    private int nBombs;
    private Cell[][] cells;
    private Cell[] bombs;
    private int numUnexposedRemaining;

    public Board(int r, int c, int b) {
        nRows = r;
        nColumns = c;
        nBombs = b;

        initializeBoard();
        shuffleBoard();
        setNumberedCells();

        numUnexposedRemaining = nRows * nColumns - nBombs;
    }

    public void printBoard(boolean showUnderside) {
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < nColumns; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < nColumns; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int r = 0; r < nRows; r++) {
            System.out.print(r + "| ");
            for (int c = 0; c < nColumns; c++) {
                if (showUnderside) {
                    System.out.print(cells[r][c].getUndersideState());
                } else {
                    System.out.print(cells[r][c].getSurfaceState());
                }
            }
            System.out.println();
        }
    }

    public UserPlayResult playFlip(UserPlay play) {
        Cell cell = getCellAtLocation(play);
        if (cell == null) {
            return new UserPlayResult(false, GameState.RUNNING);
        }

        if (play.isGuess()) {
            boolean guessResult = cell.toggleGuess();
            return new UserPlayResult(guessResult, GameState.RUNNING);
        }

        boolean result = flipCell(cell);

        if (cell.isBomb()) {
            return new UserPlayResult(result, GameState.LOST);
        }

        if (cell.isBlank()) {
            expandBlank(cell);
        }

        if (numUnexposedRemaining == 0) {
            return new UserPlayResult(result, GameState.WON);
        }

        return new UserPlayResult(result, GameState.RUNNING);
    }

    private void expandBlank(Cell cell) {
        int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        LinkedList<Cell> toExplore = new LinkedList<>();
        toExplore.addLast(cell);

        while (!toExplore.isEmpty()) {
            Cell current = toExplore.removeFront().data;

            for (int[] delta : deltas) {
                int r = current.getRow() + delta[0];
                int c = current.getColumn() + delta[1];
                if (inBounds(r, c)) {
                    Cell neighbor = cells[r][c];
                    if (flipCell(neighbor) && neighbor.isBlank()) {
                        toExplore.addLast(neighbor);
                    }
                }
            }
        }
    }

    public int getNumRemaining() {
        return numUnexposedRemaining;
    }

    private boolean flipCell(Cell cell) {
        if (!cell.isExposed() && !cell.isGuess()) {
            cell.flip();
            numUnexposedRemaining--;
            return true;
        }
        return false;
    }

    private Cell getCellAtLocation(UserPlay play) {
        int row = play.getRow();
        int col = play.getColumn();
        if (!inBounds(row, col)) {
            return null;
        }
        return cells[row][col];
    }

    private void initializeBoard() {
        cells = new Cell[nRows][nColumns];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nColumns; c++) {
                cells[r][c] = new Cell(r, c);
            }
        }
        bombs = new Cell[nBombs];
        for (int i = 0; i < nBombs; i++) {
            int row = i / nColumns;
            int column = i % nColumns;
            bombs[i] = cells[row][column];
            cells[row][column].setBomb();
        }
    }

    private void shuffleBoard() {
        int nCells = nRows * nColumns;
        Random random = new Random();
        for (int index1 = 0; index1 < nCells; index1++) {
            int index2 = index1 + random.nextInt(nCells - index1);
            if (index1 != index2) {
                /* Get cell at index1. */
                int row1 = index1 / nColumns;
                int column1 = index1 % nColumns;
                Cell cell1 = cells[row1][column1];

                /* Get cell at index2. */
                int row2 = index2 / nColumns;
                int column2 = index2 % nColumns;
                Cell cell2 = cells[row2][column2];

                cells[row1][column1] = cell2;
                cell2.setRowAndColumn(row1, column1);
                cells[row2][column2] = cell1;
                cell1.setRowAndColumn(row2, column2);
            }
        }
    }

    private void setNumberedCells() {
        int[][] deltas = { // Offsets of 8 surrounding cells
                {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (Cell bomb : bombs) {
            int row = bomb.getRow();
            int col = bomb.getColumn();
            for (int[] delta : deltas) {
                int r = row + delta[0];
                int c = col + delta[1];
                if (inBounds(r, c)) {
                    cells[r][c].incrementNumber();
                }
            }
        }
    }

    private boolean inBounds(int row, int column) {
        return row >= 0 && row < nRows && column >= 0 && column < nColumns;
    }
}
package _9_objectorienteddesign.example6_1;

import _4_linkedlists.datastructures.LinkedList;

import java.util.Random;

public class Question {

    private static boolean testSize(int size) {
        Puzzle puzzle = initializePuzzle(size);
        Piece[][] solution = puzzle.solve();
        System.out.println(solutionToString(solution));
        return validate(solution);
    }

    private static Puzzle initializePuzzle(int size) {
        Piece[][] puzzleArray = new Piece[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                Edge[] edges = createEdges(puzzleArray, row, column);
                puzzleArray[row][column] = new Piece(edges);
            }
        }

        LinkedList<Piece> pieces = new LinkedList<>();

        Puzzle puzzle = new Puzzle(size, pieces);
        Random r = new Random();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                int rotations = r.nextInt(4);
                Piece piece = puzzleArray[row][column];
                piece.rotateEdgesBy(rotations);
                int index = pieces.size() == 0 ? 0 : r.nextInt(pieces.size());
                pieces.add(index, piece);
            }
        }
        return puzzle;
    }

    public static boolean validate(Piece[][] solution) {
        if (solution == null)
            return false;
        for (int r = 0; r < solution.length; r++) {
            for (int c = 0; c < solution[r].length; c++) {
                Piece piece = solution[r][c];
                if (piece == null)
                    return false;
                if (c > 0) { /* match left */
                    Piece left = solution[r][c - 1];
                    if (!left.getEdgeWithOrientation(EdgeOrientation.RIGHT)
                            .fitsWith(piece.getEdgeWithOrientation(EdgeOrientation.LEFT))) {
                        return false;
                    }
                }

                if (c < solution[r].length - 1) { /* match right */
                    Piece right = solution[r][c + 1];
                    if (!right.getEdgeWithOrientation(EdgeOrientation.LEFT)
                            .fitsWith(piece.getEdgeWithOrientation(EdgeOrientation.RIGHT))) {
                        return false;
                    }
                }

                if (r > 0) { /* match top */
                    Piece top = solution[r - 1][c];
                    if (!top.getEdgeWithOrientation(EdgeOrientation.BOTTOM)
                            .fitsWith(piece.getEdgeWithOrientation(EdgeOrientation.TOP))) {
                        return false;
                    }
                }

                if (r < solution.length - 1) { /* match bottom */
                    Piece bottom = solution[r + 1][c];
                    if (!bottom.getEdgeWithOrientation(EdgeOrientation.TOP)
                            .fitsWith(piece.getEdgeWithOrientation(EdgeOrientation.BOTTOM))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static Edge[] createEdges(Piece[][] puzzleArray, int row, int column) {
        String key = row + ":" + column + ":";

        Edge left = column == 0 ?
                new Edge(EdgeShape.FLAT, key + "h|e") :
                puzzleArray[row][column - 1].getEdgeWithOrientation(EdgeOrientation.RIGHT)._createMatchingEdge();
        Edge top = row == 0 ?
                new Edge(EdgeShape.FLAT, key + "v|e") :
                puzzleArray[row - 1][column].getEdgeWithOrientation(EdgeOrientation.BOTTOM)._createMatchingEdge();

        Edge right = column == puzzleArray.length - 1 ? new Edge(EdgeShape.FLAT, key + "h|e") : createRandomEdge(key + "h");

        Edge bottom = row == puzzleArray.length - 1 ? new Edge(EdgeShape.FLAT, key + "v|e") : createRandomEdge(key + "v");

        return new Edge[]{left, top, right, bottom};
    }

    private static Edge createRandomEdge(String code) {
        Random random = new Random();
        EdgeShape type = EdgeShape.INNER;
        if (random.nextBoolean()) {
            type = EdgeShape.OUTER;
        }
        return new Edge(type, code);
    }

    public static String solutionToString(Piece[][] solution) {
        if (solution == null) return "ERROR";

        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < solution.length; h++) {
            for (int w = 0; w < solution[h].length; w++) {
                Piece p = solution[h][w];
                if (p == null) {
                    sb.append("null");
                }
                else {
                    sb.append(p.toString());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int size = 1; size < 3; size++) {
            if (!testSize(size)) {
                System.out.println("ERROR: " + size);
            }
        }
    }
}

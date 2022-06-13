package _9_objectorienteddesign.example6_1;

import _4_linkedlists.datastructures.LinkedList;

public class Puzzle {
    private LinkedList<Piece> pieces;
    private int size;
    private Piece[][] solution;

    public Puzzle(int size, LinkedList<Piece> pieces) {
        this.pieces = pieces;
        this.size = size;
    }

    public Piece[][] solve() {
        /* Group pieces. */
        LinkedList<Piece> cornerPieces = new LinkedList<>();
        LinkedList<Piece> borderPieces = new LinkedList<>();
        LinkedList<Piece> insidePieces = new LinkedList<>();
        groupPieces(cornerPieces, borderPieces, insidePieces);

        solution = new Piece[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                LinkedList<Piece> piecesToSearch = getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row, column);
                if (!fitNextEdge(piecesToSearch, row, column)) {
                    return null;
                }
            }
        }
        return solution;
    }

    private LinkedList<Piece> getPieceListToSearch(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces, LinkedList<Piece> insidePieces, int row, int column) {
        if (isBorderIndex(row) && isBorderIndex(column)) {
            return cornerPieces;
        } else if (isBorderIndex(row) || isBorderIndex(column)) {
            return borderPieces;
        } else {
            return insidePieces;
        }
    }

    private boolean isBorderIndex(int location) {
        return location == 0 || location == size - 1;
    }

    private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int column) {
        if (row == 0 && column == 0) {
            Piece p = piecesToSearch.removeFront().data;
            orientTopLeftCorner(p);
            solution[0][0] = p;
        } else {
            Piece pieceToMatch = column == 0 ? solution[row - 1][0] : solution[row][column - 1];
            EdgeOrientation orientationToMatch = column == 0 ? EdgeOrientation.BOTTOM : EdgeOrientation.RIGHT;
            Edge edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch);
            Edge edge = getMatchingEdge(edgeToMatch, piecesToSearch);
            if (edge == null) return false;
            EdgeOrientation orientation = orientationToMatch.getOpposite();
            setEdgeInSolution(piecesToSearch, edge, row, column, orientation);
        }
        return true;
    }

    private void setEdgeInSolution(LinkedList<Piece> pieces, Edge edge, int row, int column, EdgeOrientation orientation) {
        Piece piece = edge.getParentPiece();
        piece.setEdgeAsOrientation(edge, orientation);
        pieces.removeNode(piece);
        solution[row][column] = piece;
    }

    private Edge getMatchingEdge(Edge targetEdge, LinkedList<Piece> pieces) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece piece = pieces.get(i);
            Edge matchingEdge = piece.getMatchingEdge(targetEdge);
            if (matchingEdge != null) {
                return matchingEdge;
            }
        }
        return null;
    }

    private void orientTopLeftCorner(Piece piece) {
        if (!piece.isCorner()) return;

        EdgeOrientation[] orientations = EdgeOrientation.values();
        for (int i = 0; i < orientations.length; i++) {
            Edge current = piece.getEdgeWithOrientation(orientations[i]);
            Edge next = piece.getEdgeWithOrientation(orientations[(i + 1) % orientations.length]);
            if (current.getShape() == EdgeShape.FLAT && next.getShape() == EdgeShape.FLAT) {
                piece.setEdgeAsOrientation(current, EdgeOrientation.LEFT);
                return;
            }
        }
    }

    private void groupPieces(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces,
            LinkedList<Piece> insidePieces) {
        for (int i = 0; i < pieces.size(); i++) {
            Piece piece = pieces.get(i);
            if (piece.isCorner()) {
                cornerPieces.addLast(piece);
            } else if (piece.isBorder()) {
                borderPieces.addLast(piece);
            } else {
                insidePieces.addLast(piece);
            }
        }
    }
}

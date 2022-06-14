package _9_objectorienteddesign.example6_1;

import _3_arraysandstrings.datastructures.HashTable;

public class Piece {
    private final static int NUMBER_OF_EDGES = 4;

    private HashTable<EdgeOrientation, Edge> edges = new HashTable<>();

    public Piece(Edge[] edgeList) {
        EdgeOrientation[] orientations = EdgeOrientation.values();
        for (int i = 0; i < edgeList.length; i++) {
            Edge edge = edgeList[i];
            edge.setParentPiece(this);
            edges.put(orientations[i], edge);
        }
    }

    public Edge getEdgeWithOrientation(EdgeOrientation orientation) {
        return edges.get(orientation);
    }

    public void rotateEdgesBy(int numberRotations) {
        EdgeOrientation[] orientations = EdgeOrientation.values();
        HashTable<EdgeOrientation, Edge> rotated = new HashTable<>();

        if (numberRotations < 0)
            numberRotations += NUMBER_OF_EDGES;

        for (int i = 0; i < orientations.length; i++) {
            EdgeOrientation oldOrientation = orientations[i];
            EdgeOrientation newOrientation = orientations[(i + numberRotations) % NUMBER_OF_EDGES];
            rotated.put(newOrientation, edges.get(oldOrientation));
        }
        edges = rotated;
    }

    public boolean isCorner() {
        EdgeOrientation[] orientations = EdgeOrientation.values();
        for (int i = 0; i < orientations.length; i++) {
            EdgeShape current = edges.get(orientations[i]).getShape();
            EdgeShape next = edges.get(orientations[(i + 1) % NUMBER_OF_EDGES]).getShape();
            if (current == EdgeShape.FLAT && next == EdgeShape.FLAT) {
                return true;
            }
        }
        return false;
    }

    public boolean isBorder() {
        EdgeOrientation[] orientations = EdgeOrientation.values();
        for (int i = 0; i < orientations.length; i++) {
            if (edges.get(orientations[i]).getShape() == EdgeShape.FLAT) {
                return true;
            }
        }
        return false;
    }

    public void setEdgeAsOrientation(Edge edge, EdgeOrientation orientation) {
        EdgeOrientation currentOrientation = getOrientation(edge);
        rotateEdgesBy(orientation.ordinal() - currentOrientation.ordinal());
    }

    private EdgeOrientation getOrientation(Edge edge) {
        return edges.getKey(edge);
    }

    public Edge getMatchingEdge(Edge targetEdge) {
        EdgeOrientation[] orientations = EdgeOrientation.values();
        for (int i = 0; i < orientations.length; i++) {
            Edge e = edges.get(orientations[i]);
            if (targetEdge.fitsWith(e)) {
                return e;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        EdgeOrientation[] orientations = EdgeOrientation.values();
        for (EdgeOrientation o : orientations) {
            sb.append(edges.get(o).toString() + ",");
        }
        return "[" + sb.toString() + "]";
    }
}

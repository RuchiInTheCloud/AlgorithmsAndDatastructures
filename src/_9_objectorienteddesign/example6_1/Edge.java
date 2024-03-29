package _9_objectorienteddesign.example6_1;

public class Edge {
    EdgeShape shape;
    private Piece parentPiece;
    String code;

    public Edge(EdgeShape shape, String code) {
        this.shape = shape;
        this.code = code;
    }

    public void setParentPiece(Piece parentPiece) {
        this.parentPiece = parentPiece;
    }

    public Piece getParentPiece() {
        return parentPiece;
    }

    public Edge _createMatchingEdge() {
        if (shape == EdgeShape.FLAT)
            return null;
        return new Edge(shape.getOpposite(), code);
    }

    public EdgeShape getShape() {
        return shape;
    }

    public boolean fitsWith(Edge edge) {
        return edge.getCode().equals(code);
    }

    private String getCode() {
        return code;
    }

    public String toString() {
        return code;
    }
}

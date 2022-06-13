package _9_objectorienteddesign.example6_1;

public class Edge {
    EdgeShape shape;

    public Edge(EdgeShape shape) {
        this.shape = shape;
    }

    public Edge _createMatchingEdge() {
        if (shape == EdgeShape.FLAT)
            return null;
        return new Edge(shape.getOpposite());
    }

    public EdgeShape getShape() {
        return shape;
    }

    public boolean fitsWith(Edge edge) {
        switch (shape) {
            case INNER:
                return edge.getShape() == EdgeShape.OUTER;
            case OUTER:
                return edge.getShape() == EdgeShape.INNER;
            default:
                return false;
        }
    }
}

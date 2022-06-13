package _9_objectorienteddesign.example6_1;

public enum EdgeShape {
    INNER, OUTER, FLAT;

    public EdgeShape getOpposite() {
        switch (this) {
            case INNER: return OUTER;
            case OUTER: return INNER;
            default: return null;
        }
    }
}

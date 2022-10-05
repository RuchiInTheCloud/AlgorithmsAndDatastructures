package _17_moderate.example22_1;

public enum Orientation {
    left,
    up,
    right,
    down;

    public Orientation getTurn(boolean clockwise) {
        switch (this) {
            case left:
                return clockwise ? up : down;
            case up:
                return clockwise ? right : left;
            case right:
                return clockwise ? down : up;
            default:
                return clockwise ? left : right;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case left:
                return "\u2190";
            case up:
                return "\u2191";
            case right:
                return "\u2192";
            default:
                return "\u2193s";
        }
    }
}

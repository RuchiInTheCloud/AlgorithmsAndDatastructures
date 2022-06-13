package _9_objectorienteddesign.example6_1;

public enum EdgeOrientation {
    LEFT, TOP, RIGHT, BOTTOM;

    public EdgeOrientation getOpposite() {
        switch (this) {
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case TOP: return BOTTOM;
            case BOTTOM: return TOP;
            default: return null;
        }
    }
}

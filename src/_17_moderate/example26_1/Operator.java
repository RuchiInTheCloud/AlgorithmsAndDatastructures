package _17_moderate.example26_1;

public enum Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    BLANK;

    static double applyOp(double left, Operator op, double right) {
        switch (op) {
            case ADD:
                return left + right;
            case SUBTRACT:
                return left - right;
            case MULTIPLY:
                return left * right;
            case DIVIDE:
                return left / right;
            default:
                return right;
        }
    }

    static int priorityOfOperator(Operator op) {
        switch (op) {
            case ADD:
                return 1;
            case SUBTRACT:
                return 1;
            case MULTIPLY:
                return 2;
            case DIVIDE:
                return 2;
            default:
                return 0;
        }
    }
}

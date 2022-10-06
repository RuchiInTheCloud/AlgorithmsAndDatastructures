package _17_moderate.example26_1;

import _3_arraysandstrings.datastructures.ArrayList;

/*
Given arithmetic equation with positive integers and +, -, *, /, compute result
*, / have higher priority than +, -
3 + 6 * 2 = 15 not 18
Process from left to right
 */
public class Example26_1 {
    static double compute(String sequence) {
        ArrayList<Term> terms = Term.parseTermSequence(sequence);
        if (terms == null)
            return Integer.MIN_VALUE;
        double result = 0;
        Term processing = null;
        for (int i = 0; i < terms.size(); i++) {
            Term current = terms.get(i);
            Term next = i + 1 < terms.size() ? terms.get(i + 1) : null;

            processing = collapseTerm(processing, current);

            if (next == null || next.getOperator() == Operator.ADD || next.getOperator() == Operator.SUBTRACT) {
                result = Operator.applyOp(result, processing.getOperator(), processing.getNumber());
                processing = null;
            }
        }
        return result;
    }

    static Term collapseTerm(Term primary, Term secondary) {
        if (primary == null)
            return secondary;
        if (secondary == null)
            return primary;

        double value = Operator.applyOp(primary.getNumber(), secondary.getOperator(), secondary.getNumber());
        primary.setNumber(value);
        return primary;
    }

    public static void main(String[] args) {
        System.out.println(compute("2-6-7*8/2+5"));
    }
}

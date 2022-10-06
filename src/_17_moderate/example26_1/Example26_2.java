package _17_moderate.example26_1;

import java.util.Stack;

/*
Given arithmetic equation with positive integers and +, -, *, /, compute result
*, / have higher priority than +, -
3 + 6 * 2 = 15 not 18
Use stacks
 */
public class Example26_2 {
    static double compute(String sequence) {
        Stack<Double> numberStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();
        for (int i = 0; i < sequence.length(); i++) {
            try {
                int value = Term.parseNextNumber(sequence, i);
                numberStack.push((double) value);

                i += Integer.toString(value).length();
                if (i >= sequence.length()) {
                    break;
                }

                Operator op = Term.parseOperator(sequence.charAt(i));
                collapseTop(op, numberStack, operatorStack);
                operatorStack.push(op);
            } catch (NumberFormatException ex) {
                return Integer.MIN_VALUE;
            }
        }

        collapseTop(Operator.BLANK, numberStack, operatorStack);
        if (numberStack.size() == 1 && operatorStack.size() == 0) {
            return numberStack.pop();
        }
        return 0;
    }

    static void collapseTop(Operator futureTop, Stack<Double> numberStack, Stack<Operator> operatorStack) {
        while (operatorStack.size() >= 1 && numberStack.size() >= 2) {
            if (Operator.priorityOfOperator(futureTop) <= Operator.priorityOfOperator(operatorStack.peek())) {
                double second = numberStack.pop();
                double first = numberStack.pop();
                Operator op = operatorStack.pop();
                double collapsed = Operator.applyOp(first, op, second);
                numberStack.push(collapsed);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(compute("2-6-7*8/2+5"));
    }
}

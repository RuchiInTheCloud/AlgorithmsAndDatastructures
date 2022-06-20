package _10_recursionanddynamicprogramming;

//Given boolean expression consisting of 0, 1, &, |, ^ and a desired result
//Implement a function to count the number of ways of parenthesizing the expression such that it evaluates to result
//The expression should not be extraneously parenthesized
//
//countEval(1^0|0|1, false)
//  countEval((1)^(0|0|1), false)
//      countEval(1, false)
//      countEval(1, true)
//      countEval(0|0|1, false)
//          countEval(0, false)
//          countEval(0|1, false)
//          countEval(0|0, false)
//          countEval(1, false)
//      countEval(0|0|1, true)
//          countEval(0, true)
//          countEval(0|1, true)
//              countEval(0, true)
//              countEval(1, true)
//          countEval(0|0, true)
//          countEval(1, true)
//  countEval((1^0)|(0|1), false)
//      countEval(1^0, false)
//      countEval(0|1, false)
//  countEval((1^0|0)|(1), false)
//      countEval(1^0|0, false)
//      countEval(1, false)
//
//
// countEval(left & right, true) = countEval(left, true) * countEval(right, true)
// countEval(left | right, true) = countEval(left, true) * countEval(right, true) + countEval(left, true) * countEval(right, false)
//                                  + countEval(left, false) * countEval(right, true)
// countEval(left ^ right, true) = countEval(left, true) * countEval(right, false) + countEval(left, false) * countEval(right, true)

public class Example14_1 {
    private static int countEval(String expression, boolean result) {
        if (expression.length() == 0)
            return 0;
        if (expression.length() == 1)
            return result == stringToBool(expression) ? 1 : 0;

        int ways = 0;
        for (int i = 1; i < expression.length(); i += 2) {
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1);
            char operation = expression.charAt(i);

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            switch (operation) {
                case '&':
                    totalTrue += leftTrue * rightTrue;
                    break;
                case '|':
                    totalTrue += leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
                    break;
                case '^':
                    totalTrue += leftFalse * rightTrue + leftTrue * rightFalse;
                    break;
                default:
                    break;
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }
        return ways;
    }

    private static boolean stringToBool(String c) {
        return c.equals("1");
    }

    public static void main(String[] args) {
        int ways = countEval("1^0|0|1", false);
        System.out.println(ways);
    }
}

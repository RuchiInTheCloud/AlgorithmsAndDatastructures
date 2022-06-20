package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.HashTable;

public class Example14_2 {
    private static int countEval(String expression, boolean result) {
        HashTable<String, Integer> memo = new HashTable<>();
        return countEval(expression, result, memo);
    }

    private static int countEval(String expression, boolean result, HashTable<String, Integer> memo) {
        if (expression.length() == 0)
            return 0;
        if (expression.length() == 1)
            return result == stringToBool(expression) ? 1 : 0;
        if (memo.containsKey(result + expression))
            return memo.get(result + expression);

        int ways = 0;
        for (int i = 1; i < expression.length(); i += 2) {
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1);
            char operation = expression.charAt(i);

            int leftTrue = countEval(left, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightTrue = countEval(right, true, memo);
            int rightFalse = countEval(right, false, memo);

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
        memo.put(result + expression, ways);
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

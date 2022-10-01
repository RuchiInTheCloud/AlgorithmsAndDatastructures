package _10_recursionanddynamicprogramming;

import java.util.HashSet;

//Input: 3
//Output: ((())), (()()),(())(),()(()),()()()
//
//P(0) = ""
//P(1) = ()
//P(2) = ()() (())
//P(3) = ()()() (())() ()(()) (()()) ((()))
//P(3) = Place () at the front and after every opening brace in every element of P(2)
public class Example9_1 {
    private static HashSet<String> parantheses(int num) {
        HashSet<String> parentheses = new HashSet<>();
        if (num == 0) {
            parentheses.add("");
        } else {
            HashSet<String> subSolutions = parantheses(num - 1);
            for (String solution : subSolutions) {
                for (int i = 0; i < solution.length(); i++) {
                    if (solution.charAt(i) == '(') {
                        String before = solution.substring(0, i + 1);
                        String after = solution.substring(i + 1);
                        parentheses.add(before + "()" + after);
                    }
                }
                parentheses.add("()" + solution);
            }
        }
        return parentheses;
    }

    public static void main(String[] args) {
        HashSet<String> combinations = parantheses(3);
        System.out.println(combinations);
    }
}

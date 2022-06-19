package _10_recursionanddynamicprogramming;

import java.util.HashSet;

//Input: 3
//Output: ((())), (()()),(())(),()(()),()()()
//
public class Example9_2 {
    public static void main(String[] args) {
        HashSet<String> combinations = parantheses(3);
        System.out.println(combinations);
    }
}

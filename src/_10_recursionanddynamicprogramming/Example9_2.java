package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

import java.util.HashSet;

//Input: 3
//Output: ((())), (()()),(())(),()(()),()()()
//
//Keep track of left parentheses remaining and right parentheses remaining
//If left > 0, add left parentheses
//If right > left, add right parentheses
public class Example9_2 {
    private static ArrayList<String> parantheses(int num) {
        ArrayList<String> resultList = new ArrayList<>();
        char[] parenthesesArray = new char[2 * num];
        parantheses(num, num, 0, parenthesesArray, resultList);
        return resultList;
    }

    private static void parantheses(int leftRemaining, int rightRemaining, int index, char[] parenthesesArray,
            ArrayList<String> resultList) {
        if (leftRemaining < 0 || rightRemaining < 0) {
            return;
        }

        if (leftRemaining == 0 && rightRemaining == 0) {
            String parenthesesString = String.copyValueOf(parenthesesArray);
            resultList.add(parenthesesString);
        } else {
            if (leftRemaining > 0) {
                parenthesesArray[index] = '(';
                parantheses(leftRemaining - 1, rightRemaining, index + 1, parenthesesArray, resultList);
            }

            if (rightRemaining > leftRemaining) {
                parenthesesArray[index] = ')';
                parantheses(leftRemaining, rightRemaining - 1, index + 1, parenthesesArray, resultList);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> combinations = parantheses(3);
        System.out.println(combinations);
    }
}

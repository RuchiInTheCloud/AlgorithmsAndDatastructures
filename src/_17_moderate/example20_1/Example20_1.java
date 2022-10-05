package _17_moderate.example20_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Given numeric keypad (each digit maps to 0 - 4 letters, valid words, and user input (sequence of digits)
---> Provide list of words that match the numbers
Try every possible letter for a digit with all other possible values
Look up whether string created exists in the valid words
Complexity O(4^n)
 */
public class Example20_1 {
    static char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    static ArrayList<String> getValidT9Words(String number, HashSet<String> wordList) {
        ArrayList<String> results = new ArrayList<>();
        getValidWords(number, 0, "", wordList, results);
        return results;
    }

    static void getValidWords(String number, int index, String prefix, HashSet<String> wordSet,
            ArrayList<String> results) {
        if (index == number.length()) {
            if (wordSet.contains(prefix)) {
                results.add(prefix);
            }
            return;
        }
        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);

        if (letters != null) {
            for (char letter : letters) {
                getValidWords(number, index + 1, prefix + letter, wordSet, results);
            }
        }
    }

    static char[] getT9Chars(char digit) {
        if (!Character.isDigit(digit)) {
            return null;
        }
        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }

    public static void main(String[] args) {
        HashSet<String> wordList = new HashSet<>(List.of("tree", "used", "abba"));
        System.out.println(getValidT9Words("8733", wordList));
    }
}

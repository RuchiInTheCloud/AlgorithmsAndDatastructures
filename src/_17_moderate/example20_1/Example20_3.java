package _17_moderate.example20_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Given numeric keypad (each digit maps to 0 - 4 letters, valid words, and user input (sequence of digits)
---> Provide list of words that match the numbers
Precomputation: Convert dictionary into hashmap of key: sequence of digits, value: list of valid words
Then when user provides input lookup in the dictionary
 */
public class Example20_3 {
    static char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    static List<String> getValidT9Words(String numbers, HashMap<String, List<String>> dictionary) {
        return dictionary.get(numbers);
    }

    static HashMap<String, List<String>> initializeDictionary(String[] words) {
        HashMap<Character, Character> letterToNumberMap = createLetterToNumberMap();

        HashMap<String, List<String>> numbersToWords = new HashMap<>();
        for (String word : words) {
            String number = convertToT9(word, letterToNumberMap);
            List<String> wordsMatchingNumber = numbersToWords.get(number);
            if (wordsMatchingNumber == null) {
                wordsMatchingNumber = new ArrayList<>();
                numbersToWords.put(number, wordsMatchingNumber);
            }
            wordsMatchingNumber.add(word);
        }
        return numbersToWords;
    }

    static HashMap<Character, Character> createLetterToNumberMap() {
        HashMap<Character, Character> letterToNumberMap = new HashMap<>();
        for (int i = 0; i < t9Letters.length; i++) {
            char[] letters = t9Letters[i];
            if (letters != null) {
                for (char letter : letters) {
                    char c = Character.forDigit(i, 10);
                    letterToNumberMap.put(letter, c);
                }
            }
        }
        return letterToNumberMap;
    }

    static String convertToT9(String word, HashMap<Character, Character> lettersToNumbersMap) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (lettersToNumbersMap.containsKey(c)) {
                char digit = lettersToNumbersMap.get(c);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] wordList = {"tree", "used", "abba"};
        HashMap<String, List<String>> numbersToWords = initializeDictionary(wordList);
        List<String> words = getValidT9Words("8733", numbersToWords);

        System.out.println(words);
    }
}

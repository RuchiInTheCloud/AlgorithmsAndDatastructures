package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;
import _3_arraysandstrings.datastructures.HashTable;

//Write a method to compute permutations of a string whose characters are not unique
//Create unique permutations
//P(aaa) = {a + P(aa)} + {a + P(aa)} + {a + P(aa)}
//Improvement:
//First compute the char frequency table
//P(a->2, b->4, c->1) = {a + P(a->1, b->4, c->1)} + {b + P(a->2, b->3, c->1)} + {c + P(a->2, b->4, c->0)}
public class Example8_1 {
    private static ArrayList<String> permutation(String string) {
        HashTable<Character, Integer> charFrequency = buildCharFrequency(string);
        ArrayList<String> permutations = new ArrayList<>();
        permutation(charFrequency, string.length(), "", permutations);
        return permutations;
    }

    private static HashTable<Character, Integer> buildCharFrequency(String string) {
        HashTable<Character, Integer> charFrequency = new HashTable<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!charFrequency.containsKey(c)) {
                charFrequency.put(c, 1);
            } else {
                int count = charFrequency.get(c);
                charFrequency.put(c, count + 1);
            }
        }
        return charFrequency;
    }

    private static void permutation(HashTable<Character, Integer> charFrequency, int remaining, String prefix,
            ArrayList<String> permutations) {
        if (remaining == 0) {
            permutations.add(prefix);
        } else {
            ArrayList<Character> keySet = charFrequency.keySet();
            for (Character character : keySet) {
                int frequency = charFrequency.get(character);
                if (frequency > 0) {
                    charFrequency.put(character, frequency - 1);
                    permutation(charFrequency, remaining - 1, prefix + character, permutations);
                    charFrequency.put(character, frequency);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> permutations = permutation("aabbbbc");
        System.out.println(permutations);
    }
}

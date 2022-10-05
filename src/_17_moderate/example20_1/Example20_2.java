package _17_moderate.example20_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Given numeric keypad (each digit maps to 0 - 4 letters, valid words as trie, and user input (sequence of digits)
---> Provide list of words that match the numbers
Try every possible letter for a digit with all other possible values that exist in the trie
--> Stops recursing down paths that would obviously fail
Complexity O(dictionary size)
 */
public class Example20_2 {
    static class TrieNode {
        HashMap<Character, TrieNode> children;

        TrieNode(HashMap<Character, TrieNode> children) {
            this.children = children;
        }

        public boolean terminates() {
            return children == null;
        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }
    }

    static class Trie {
        TrieNode root;

        Trie(TrieNode root) {
            this.root = root;
        }

        public TrieNode getRoot() {
            return root;
        }
    }

    static ArrayList<String> getValidT9Words(String number, Trie trie) {
        ArrayList<String> results = new ArrayList<>();
        getValidWords(number, 0, "", trie.getRoot(), results);
        return results;
    }

    static char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    static void getValidWords(String number, int index, String prefix, TrieNode trieNode, ArrayList<String> results) {
        if (index == number.length()) {
            if (trieNode.terminates()) {
                results.add(prefix);
            }
            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);

        if (letters != null) {
            for (char letter : letters) {
                TrieNode childNode = trieNode.getChild(letter);
                if (childNode != null) {
                    getValidWords(number, index + 1, prefix + letter, childNode, results);
                }
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
        TrieNode node1 = new TrieNode(null);

        HashMap<Character, TrieNode> children = new HashMap<>();
        children.put('e', node1);

        TrieNode node2 = new TrieNode(children);

        children = new HashMap<>();
        children.put('e', node2);

        node1 = new TrieNode(children);

        children = new HashMap<>();
        children.put('r', node1);

        node2 = new TrieNode(children);

        children = new HashMap<>();
        children.put('t', node2);

        node1 = new TrieNode(children);

        Trie trie = new Trie(node1);

        System.out.println(getValidT9Words("8733", trie));
    }
}

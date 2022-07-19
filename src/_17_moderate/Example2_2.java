package _17_moderate;

import java.util.HashMap;

//Design a method to find the frequency of occurences of any given word in a book
//What if we were running this algorithm multiple times
public class Example2_2 {
    private static HashMap<String, Integer> getFrequencyTable(String[] words) {
        HashMap<String, Integer> frequencyTable = new HashMap<>();
        for (String word : words) {
            word = word.trim().toLowerCase();
            if (!word.isBlank()) {
                if (!frequencyTable.containsKey(word)) {
                    frequencyTable.put(word, 0);
                }
                frequencyTable.put(word, frequencyTable.get(word) + 1);
            }
        }
        return frequencyTable;
    }

    private static int getFrequency(HashMap<String, Integer> frequencyTable, String word) {
        if (frequencyTable == null || word == null)
            return -1;

        word = word.trim().toLowerCase();
        if (frequencyTable.containsKey(word)) {
            return frequencyTable.get(word);
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] words = {" Ruchi", "RUCHI ", "Ru chi", "xyz"};
        String word = "RuChi";
        HashMap<String, Integer> frequencyTable = getFrequencyTable(words);
        System.out.println(getFrequency(null, null));
        System.out.println(getFrequency(null, word));
        System.out.println(getFrequency(frequencyTable, null));
        System.out.println(getFrequency(frequencyTable, word));
    }
}

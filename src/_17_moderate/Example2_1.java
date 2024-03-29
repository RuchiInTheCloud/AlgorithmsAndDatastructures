package _17_moderate;

//Design a method to find the frequency of occurences of any given word in a book
public class Example2_1 {
    private static int getFrequency(String[] words, String word) {
        word = word.trim().toLowerCase();
        int frequency = 0;
        for (String w : words) {
            if (w.trim().toLowerCase().equals(word)) {
                frequency++;
            }
        }
        return frequency;
    }

    public static void main(String[] args) {
        String[] words = {" Ruchi", "RUCHI ", "Ru chi", "xyz"};
        String word = "RuChi";
        System.out.println(getFrequency(words, word));
    }
}

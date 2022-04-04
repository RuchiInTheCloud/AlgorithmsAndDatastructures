package onotation;

public class Example13 {
    //Time complexity O(n!)
    //Space complexity O(n)
    static void permutation(String str) {
        permutation(str, "");
    }

    //7 * 6 * 5 * 4 * 3 * 2 * 1
    //First call there are 7 recursive calls/ choices, then 6 recursive calls, then 5
    static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("a".substring(1));
        permutation("Ruchi");
    }
}

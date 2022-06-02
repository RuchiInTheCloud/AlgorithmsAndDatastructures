package arraysandstrings;

//Given: Two strings. Check if one is rotation of the other using isSubstring
//s1 = xy, s2 = yx
//Example: s1 = waterbottle s2 = erbottlewat
//Example: s1 = aba s2 = baa
//Bruteforce: concatenate s1s1 = xyxy, check whether s2 is substring of s1s1
//Complexity: O(A+B)
//Optimize:
//Walk through:
//Test:
public class Example9_1 {
    private static boolean isSubstring(String s, String sub) {
        return s.contains(sub);
    }

    private static boolean isRotation(String s1, String s2) {
        return s1.length() == s2.length() ? isSubstring((s1 + s1), s2) : false;
    }

    public static void main(String[] args) {
        System.out.println("erbottlewat is rotation of waterbottle: " + isRotation("waterbottle", "erbottlewat"));
        System.out.println("aba is rotation of baa: " + isRotation("aba", "baa"));
    }
}

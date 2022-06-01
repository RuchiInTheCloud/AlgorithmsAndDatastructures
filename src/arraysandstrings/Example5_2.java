package arraysandstrings;

//Edit: Insert character, Remove a character, Replace a character
//Write method to determine if two strings a at most one edit away
//Example:
//1. abc, abcd
//2. abcd, abc
//3. abc, abd
//4. abc, abc
//5. abc, acd
//6. abc, abcde
//Brute force: traverse the two strings in parallel, to check whether they are one edit away
//Brute force complexity: time = O(n), space = O(1)
//Optimize: BCR
//Walk through:
// If strings length has a difference of more than one return false
// Record the string with the smaller length
// Loop through both strings
// If the characters are the same, increment both index
// If the characters are different
//      Record the difference, if it appears again, return false
//      Increment first index only if both strings have same length and increment the second index regardless.
//Implement
//Test:
public class Example5_2 {
    public static boolean isOneEditAway(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        String first = str1.length() < str2.length() ? str1 : str2;
        String second = str1.length() < str2.length() ? str2 : str1;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) == second.charAt(index2)) {
                index1++;
                index2++;
            } else {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (first.length() == second.length()) {
                    index1++;
                }
                index2++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Are strings one edit away \"abc\", \"abcd\" : " + (isOneEditAway("abc", "abcd") ? "yes": "no"));
        System.out.println("Are strings one edit away \"abcd\", \"abc\" : " + (isOneEditAway("abcd", "abc") ? "yes": "no"));
        System.out.println("Are strings one edit away \"abc\", \"abd\" : " + (isOneEditAway("abc", "abd") ? "yes": "no"));
        System.out.println("Are strings one edit away \"abc\", \"abc\" : " + (isOneEditAway("abc", "abc") ? "yes": "no"));
        System.out.println("Are strings one edit away \"abc\", \"acd\" : " + (isOneEditAway("abc", "acd") ? "yes": "no"));
        System.out.println("Are strings one edit away \"abc\", \"abcde\" : " + (isOneEditAway("abc", "abcde") ? "yes": "no"));
    }
}

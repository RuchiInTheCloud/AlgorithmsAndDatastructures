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
//If strings are of same length --> check whether they are one replacement way
//  traverse the two strings in parallel, if there is a difference record, if this difference appears again return false
//If strings have a length difference of 1 --> Consider the shorter string and the longer string and check whether they are an insertion away
//  traverse the two strings in parallel, if there is a difference in characters increment the counter of longer string, If a difference in characters is seen again return false
//Implement
//Test: Don't forget parentheses, semicolon
public class Example5_1 {
    public static boolean isOneEditAway(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return isMaxOneReplacementAway(str1, str2);
        } else if (str1.length() - 1 == str2.length()) {
            return isOneInsertAway(str2, str1);
        } else if (str1.length() + 1 == str2.length()) {
            return isOneInsertAway(str1, str2);
        }
        return false;
    }
    public static boolean isMaxOneReplacementAway(String str1, String str2) {
        boolean foundReplacement = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (foundReplacement) {
                    return false;
                }
                foundReplacement = true;
            }
        }
        return true;
    }
    public static boolean isOneInsertAway(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
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

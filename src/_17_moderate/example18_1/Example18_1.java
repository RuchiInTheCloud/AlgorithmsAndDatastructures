package _17_moderate.example18_1;

/*
Given two strings: pattern and value
Pattern string consists of letters a and b
E.g. String catcatgocatgo matches pattern aabab
Construct O(n) substrings for a and O(n^2) substrings for b. Construct string based on pattern and compare it to value
O(n^4)
 */
public class Example18_1 {
    static boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        int size = value.length();
        for (int mainSize = 0; mainSize < size; mainSize++) {
            String main = value.substring(0, mainSize);
            for (int altStart = mainSize; altStart <= size; altStart++) {
                for (int altEnd = altStart; altEnd <= size; altEnd++) {
                    String alt = value.substring(altStart, altEnd);
                    String cand = buildFromPattern(pattern, main, alt);
                    if (cand.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static String buildFromPattern(String pattern, String main, String alt) {
        StringBuffer sb = new StringBuffer();
        char first = pattern.charAt(0);
        for (char c : pattern.toCharArray()) {
            if (c == first) {
                sb.append(main);
            } else {
                sb.append(alt);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(doesMatch("aabab", "catcatgocatgo"));
    }
}

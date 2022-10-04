package _17_moderate;

/*
Master Mind: Computer has four slots, each slot can contain a ball that is red, yellow, green, or blue
E.g. RGGB
As a user try to guess the solution: Hit occurs if you guess the color for the correct slot
pseudo hit occurs if you guess a color that exists but in another slot
 */
public class Example15_1 {
    static class Result {
        int hits = 0;
        int pseudoHits = 0;
    }

    static int code(char c) {
        switch (c) {
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }

    static int MAX_COLORS = 4;

    static Result estimate(String guess, String solution) {
        if (guess.length() != solution.length())
            return null;

        Result result = new Result();
        int[] frequencies = new int[MAX_COLORS];

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                result.hits++;
            } else {
                int code = code(solution.charAt(i));
                frequencies[code]++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                result.pseudoHits++;
                frequencies[code]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Result result = estimate("GGRR", "RGBY");
        System.out.println(result.hits + "  " + result.pseudoHits);
    }
}

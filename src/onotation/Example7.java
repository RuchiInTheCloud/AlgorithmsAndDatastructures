package onotation;

public class Example7 {
    //Time complexity = O(ab) <-- Not O(n^2)
    //Space complexity = O(1)
    static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
                for (int k = 0; k < 100000; k++) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        printUnorderedPairs(new int[]{15, 30}, new int[]{15, 30});
    }
}

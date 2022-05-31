package onotation;

public class Example6 {
    //Time complexity = O(N^2)
    //Space complexity = O(1)

    // i < j
    //(N-1) + (N-2) + (N-3) + ... + 2 + 1 = N*(N-1)/2
    //With N^2 pairs, roughly half have i < j = N^2/2 pairs

    //Average work: Outer loop runs N times, Inner loop runs N - 1, N - 2,..., 1 = Average N/2
    static void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }

    public static void main(String[] args) {
        printUnorderedPairs(new int[]{15, 30});
    }
}

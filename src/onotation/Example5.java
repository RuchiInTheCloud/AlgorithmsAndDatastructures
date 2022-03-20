package onotation;

public class Example5 {
    //Time complexity = O(N^2)
    //Space complexity = O(1)
    static void printPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }

    public static void main(String[] args) {
        printPairs(new int[]{15, 30});
    }
}

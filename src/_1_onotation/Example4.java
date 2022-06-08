package _1_onotation;

public class Example4 {
    //Time complexity = O(N)
    //Space complexity = O(1)
    static void foo(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        System.out.println(sum + ", " + product);
    }

    public static void main(String[] args) {
        foo(new int[]{15, 30});
    }
}

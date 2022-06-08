package _1_onotation;

public class Example8 {
    //Time complexity = O(N)
    static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int other = array.length - 1 - i;
            int temp = array[other];
            array[other] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        reverse(new int[]{15, 30, 15, 30});
    }
}

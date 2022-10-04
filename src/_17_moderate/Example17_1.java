package _17_moderate;

/*
Given array of positive and negative integers. Find contiguous sequence with the largest sum
E.g. 2, -8, 3, -2, 4, -10
Build contiguous sum until it turns negative in which case reset
Contiguous subsequence of sum 0 is better than the negative sum
 */
public class Example17_1 {
    static int getMax(int[] a) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (maxSum < sum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {2, -8, 3, -2, 4, -10};
        System.out.println(getMax(a));
    }
}

package _7_bitmanipulation;

import _3_arraysandstrings.datastructures.ArrayList;

//Find the longest one sequence that you could get by flipping one zero bit that would generate the longest ones sequence
//Example:
//111111111111 --> No flip, return longest sequence
//111110001111 --> flip along the largest sequence to the left
//111110111111 --> combine the lengths of 1s sequence to the left and right + 1
//
//Bruteforce:
//Repeat until num = 0
//  Look at last bit, if 1
//      increment the current counter
//  Look at last bit,  if 0
//      previousSum = currentSum
//      reset current counter
//  maxSum = max(currentSum + previousSum + 1, maxSum)
//  Remove last bit
//
public class Example3_2 {
    private static int findLargestSequence(int num) {
        if (~num == 0) {
            return Integer.BYTES * 8;
        }

        int currentSum = 0;
        int previousSum = 0;
        int maxSum = 1;
        while (num != 0) {
            if ((num & 1) == 1) {
                currentSum += 1;
            } else if ((num & 1) == 0) {
                previousSum = currentSum;
                currentSum = 0;
            }
            maxSum = Math.max(currentSum + previousSum + 1, maxSum);
            num = num >>> 1;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findLargestSequence(11));
    }
}
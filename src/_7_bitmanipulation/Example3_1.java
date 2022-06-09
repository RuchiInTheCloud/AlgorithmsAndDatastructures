package _7_bitmanipulation;

import _3_arraysandstrings.datastructures.ArrayList;

//Find the longest one sequence that you could get by flipping one zero bit that would generate the longest ones sequence
//Example:
//111111111111 --> No flip, return longest sequence
//111110001111 --> flip along the largest sequence to the left
//111110111111 --> combine the lengths of 1s sequence to the left and right + 1
//
//Brute force
//Convert number into count of 0s sequence and 1s sequence,
//Iterate through the count to check
//Complexity: O(length of sequence or number of bits)
public class Example3_1 {
    private static int longestSequence(int num) {
        ArrayList<Integer> sequence = generateSequence(num);
        return findLargestSequence(sequence);
    }

    private static ArrayList<Integer> generateSequence(int num) {
        ArrayList<Integer> sequence = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;
        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((num & 1) != searchingFor) {
                sequence.add(counter);
                searchingFor = num & 1;
                counter = 0;
            }
            counter += 1;
            num = num >>> 1;
        }

        sequence.add(counter);
        return sequence;
    }

    private static int findLargestSequence(ArrayList<Integer> sequence) {
        int maxSeq = 1;

        int thisSeq = 0;
        for (int i = 0; i < sequence.size(); i += 2) {
            int zerosLength = sequence.get(i);
            int leftSequenceLength = i - 1 >= 0 ? sequence.get(i - 1) : 0;
            int rightSequenceLength = i + 1 < sequence.size() ? sequence.get(i + 1) : 0;

            if (zerosLength == 0) {
                thisSeq = Math.max(leftSequenceLength, rightSequenceLength);
            } else if (zerosLength > 1) {
                thisSeq = Math.max(leftSequenceLength, rightSequenceLength) + 1;
            } else if (zerosLength == 1) {
                thisSeq = leftSequenceLength + rightSequenceLength + 1;
            }
            maxSeq = Math.max(maxSeq, thisSeq);
        }
        return maxSeq;
    }

    public static void main(String[] args) {
        System.out.println(longestSequence(11));
    }
}
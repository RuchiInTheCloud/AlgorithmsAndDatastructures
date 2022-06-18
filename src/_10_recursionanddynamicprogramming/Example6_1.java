package _10_recursionanddynamicprogramming;

//Towers of Hanoi
//Rules:
// - Only one disk can be moved at a time
// - A disk cannot be placed on top of smaller disk
//
//n = 1, Move Disk 1 to Tower 3
//n = 2, Move Disk 1 to Tower 2, Move Disk 2 to Tower 3, Move Disk 1 to Tower3
//n = 3, Move Disk 1, Disk 2 to Tower 2 with Tower 3 as Buffer, Move Disk 3 to Tower 3, Move Disk 1, Disk 2 to Tower 3 with Tower 1 as Buffer
//
//General:
//Move n-1 disks to buffer using destination as buffer
//Move nth disk to destination
//Move n-1 disks to destination using original tower as buffer

import _5_stacksandqueues.datastructures.Stack;

//Time Complexity: O(2^n), Space: O(n)
//
public class Example6_1 {
    private static class Tower {
        private Stack<Integer> disks;
        private int index;

        public Tower(int index) {
            this.disks = new Stack<>();
            this.index = index;
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek().data <= d) {
                System.out.println("Error placing disk");
            } else {
                disks.push(d);
            }
        }

        public int pop() {
            return disks.pop().data;
        }

        @Override
        public String toString() {
            return "Tower " + index + " has disks = " + disks;
        }
    }

    private static void moveDisks(int n, Tower source, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, source, buffer, destination);
            moveTop(source, destination);
            moveDisks(n - 1, buffer, destination, source);
        }
    }

    private static void moveTop(Tower source, Tower destination) {
        int data = source.pop();
        destination.add(data);
    }

    public static void main(String[] args) {
        int n = 5;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        System.out.println("Before move : ");

        System.out.println("Tower 1: " + towers[0]);
        System.out.println("Tower 2: " + towers[1]);
        System.out.println("Tower 3: " + towers[2]);

        moveDisks(n, towers[0], towers[2], towers[1]);

        System.out.println("After move : ");

        System.out.println("Tower 1: " + towers[0]);
        System.out.println("Tower 2: " + towers[1]);
        System.out.println("Tower 3: " + towers[2]);
    }
}

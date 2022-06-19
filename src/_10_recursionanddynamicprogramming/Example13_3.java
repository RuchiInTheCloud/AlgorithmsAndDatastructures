package _10_recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Comparator;

public class Example13_3 {
    private static class Box {
        private int width;
        private int height;
        private int depth;

        Box(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public boolean canBeAbove(Box bottom) {
            if (bottom == null) {
                return true;
            }
            return bottom.width > width && bottom.height > height && bottom.depth > depth;
        }
    }

    private static class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box o1, Box o2) {
            return o2.height - o1.height;
        }
    }
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<>();
        Box box;
        box = new Box(5, 4, 2);
        boxes.add(box);
        box = new Box(4, 2, 1);
        boxes.add(box);
        box = new Box(5, 1, 3);
        boxes.add(box);

        int maxHeight = createStack(boxes);
        System.out.println("Maximum height possible " + maxHeight);
    }
}

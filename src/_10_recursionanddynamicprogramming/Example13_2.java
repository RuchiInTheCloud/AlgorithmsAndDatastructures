package _10_recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Comparator;

//Stack boxes on top of another and find maximum height of stack
//One can be stacked on top of another only if all dimensions are strictly smaller than the top of the stack

public class Example13_2 {
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
            if (bottom.width > width && bottom.height > height && bottom.depth > depth) {
                return true;
            }
            return false;
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

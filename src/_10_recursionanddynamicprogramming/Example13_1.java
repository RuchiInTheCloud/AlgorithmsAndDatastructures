package _10_recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Example13_1 {
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

    private static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private static int createStack(ArrayList<Box> boxes, int index) {
        Box bottom = boxes.get(index);
        int maxHeight = 0;
        for (int i = index + 1; i < boxes.size(); i++) {
            Box currentBox = boxes.get(i);
            if (currentBox.canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += bottom.height;
        return maxHeight;
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

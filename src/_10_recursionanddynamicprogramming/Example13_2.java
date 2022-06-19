package _10_recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
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
            return bottom.width > width && bottom.height > height && bottom.depth > depth;
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
        int[] maxHeightMap = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, maxHeightMap);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private static int createStack(ArrayList<Box> boxes, int index, int[] maxHeightMap) {
        if (maxHeightMap[index] > 0) {
            return maxHeightMap[index];
        }

        Box bottom = boxes.get(index);
        int maxHeight = 0;
        for (int i = index + 1; i < boxes.size(); i++) {
            Box currentBox = boxes.get(i);
            if (currentBox.canBeAbove(bottom)) {
                int height = createStack(boxes, i, maxHeightMap);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += bottom.height;
        maxHeightMap[index] = maxHeight;
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

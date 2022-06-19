package _10_recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
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

    private static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int[] maxHeightMap = new int[boxes.size()];
        return createStack(boxes, null, 0, maxHeightMap);
    }

    private static int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] maxHeightMap) {
        if (offset >= boxes.size()) {
            return 0;
        }
        
        Box newBottom = boxes.get(offset);

        int heightWithBottom = 0;
        if (newBottom.canBeAbove(bottom)) {
            if (maxHeightMap[offset] == 0) {
                maxHeightMap[offset] = createStack(boxes, newBottom, offset + 1, maxHeightMap);
                maxHeightMap[offset] += newBottom.height;
            }
            heightWithBottom = maxHeightMap[offset];
        }

        int heightWithoutBottom = createStack(boxes, bottom, offset + 1, maxHeightMap);
        return Math.max(heightWithoutBottom, heightWithBottom);
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

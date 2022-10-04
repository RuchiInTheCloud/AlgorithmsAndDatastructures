package _17_moderate.example19_1;

import java.util.ArrayList;

/*
Given integer matrix representing plot of land
value at location represents height above sea level. 0 = indicated water
Pond = region of water connected vertically horizontally and diagonally
Compute the size of all ponds
 */
public class Example19_1 {
    static ArrayList<Integer> computePondSizes(int[][] land) {
        ArrayList<Integer> pondSizes = new ArrayList<>();
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[r].length; c++) {
                if (land[r][c] == 0) {
                    int size = computeSize(land, r, c);
                    pondSizes.add(size);
                }
            }
        }
        return pondSizes;
    }

    static int computeSize(int[][] land, int row, int column) {
        if (row < 0 || column < 0 || row >= land.length || column >= land[row].length || land[row][column] != 0) {
            return 0;
        }
        int size = 1;
        land[row][column] = -1;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += computeSize(land, row + dr, column + dc);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        ArrayList<Integer> pondSizes = computePondSizes(land);
        System.out.println(pondSizes);
    }
}

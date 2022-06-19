package _10_recursionanddynamicprogramming;

import java.util.Arrays;

//Paint fill
public class Example10_1 {
    enum Color {
        Black,
        White,
        Red,
        Blue,
        Yellow,
        Green
    }

    private static void fill(Color[][] colors, int row, int col, Color color) {
        if (colors[row][col] != color) {
            fill(colors, row, col, colors[row][col], color);
        }
    }

    private static void fill(Color[][] colors, int row, int col, Color oColor, Color nColor) {
        if ((row >= 0 && row < colors.length) && (col >= 0 && col < colors[0].length) && colors[row][col] == oColor) {
            colors[row][col] = nColor;
            fill(colors, row, col - 1, oColor, nColor);
            fill(colors, row - 1, col, oColor, nColor);
            fill(colors, row, col + 1, oColor, nColor);
            fill(colors, row + 1, col, oColor, nColor);
        }
    }

    public static void main(String[] args) {
        Color[][] colors = new Color[5][10];

        System.out.println(Arrays.deepToString(colors));

        fill(colors, 0, 0, Color.Black);

        System.out.println(Arrays.deepToString(colors));
    }
}

package _12_sortingandsearching;

//Given MXN matrix with sorted rows and columns. Write method to find element.
//Bruteforce: O(MlogN). Execute binary search in every row.
//15   20   40   85
//20   35   80   95
//30   55   95  105
//40   80  100  120
//
public class Example9_2 {

    public static void main(String[] args) {
        int[][] matrix = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
        boolean isPresent = findElement(matrix, 55);
        System.out.println(isPresent);
    }
}

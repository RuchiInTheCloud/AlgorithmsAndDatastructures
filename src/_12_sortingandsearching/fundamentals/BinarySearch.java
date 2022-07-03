package _12_sortingandsearching.fundamentals;

public class BinarySearch {
    private static int binarySearch(int[] array, int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == x) {
                return mid;
            } else if ( array[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] array, int x, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == x) {
                return mid;
            } else if ( array[mid] > x) {
                return binarySearchRecursive(array, x, low, mid - 1);
            } else {
                return binarySearchRecursive(array, x, mid + 1, high);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {0, 1, 3, 4};
        System.out.println(binarySearch(array, 1, 0, array.length - 1));
        System.out.println(binarySearchRecursive(array, 1, 0, array.length - 1));
    }
}

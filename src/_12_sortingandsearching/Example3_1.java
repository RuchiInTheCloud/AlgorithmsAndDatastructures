package _12_sortingandsearching;

//Search in a sorted array that has been rotated
//O(log n) runtime if elements are unique, otherwise O(n) in
//Worst case since left and right sub arrays need to be searched
public class Example3_1 {
    private static int search(int[] a, int x, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (a[mid] == x) {
            return mid;
        }

        if (a[low] < a[mid]) {
            if (a[low] <= x && x < a[mid]) {
                return search(a, x, low, mid - 1);
            } else {
                return search(a, x, mid + 1, high);
            }
        } else if (a[low] > a[mid]) {
            if (a[mid] < x && x <= a[high]) {
                return search(a, x, mid + 1, high);
            } else {
                return search(a, x, low, mid - 1);
            }
        } else if (a[low] == a[mid]) {
            if (a[high] != a[mid]) {
                return search(a, x, mid + 1, high);
            } else {
                int index = search(a, x, low, mid - 1);
                if (index == -1) {
                    index = search(a, x, mid + 1, high);
                }
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {10, 15, 20, 0, 5};
        System.out.println(search(a, 5, 0, 4));
    }
}

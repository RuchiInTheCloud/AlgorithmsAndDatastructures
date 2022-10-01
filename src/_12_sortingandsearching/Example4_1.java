package _12_sortingandsearching;

//Listy has no size method
//Contains only positive sorted integers
public class Example4_1 {
    private static class Listy {
        int[] array;

        Listy(int[] array) {
            this.array = array;
        }

        public int elementAt(int i) {
            return i > (array.length - 1) ? -1 : array[i];
        }
    }

    private static int search(Listy list, int value) {
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }
        return binarySearch(list, index / 2, index, value);
    }

    private static int binarySearch(Listy list, int low, int high, int value) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int medium = list.elementAt(mid);
            if (medium == value) {
                return mid;
            } else if (medium > value || medium == -1) {
                high = mid - 1;
            } else if (medium < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 7, 9, 11};
        Listy list = new Listy(array);
        int index = search(list, 9);
        System.out.println(index);
    }
}

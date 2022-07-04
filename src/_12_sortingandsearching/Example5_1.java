package _12_sortingandsearching;

//Given sorted array of strings with interspersed empty strings
//Worst case runtime O(n): All strings in the array may be empty but one.
//Is searching for empty string an error?
public class Example5_1 {
    private static int search(String[] strings, String string, int first, int last) {
        if (last < first) {
            return -1;
        }

        int mid = (first + last) / 2;

        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if (strings[mid].equals(string)) {
            return mid;
        } else if (strings[mid].compareTo(string) < 0) {
            return search(strings, string, mid + 1, last);
        } else if (strings[mid].compareTo(string) > 0) {
            return search(strings, string, first, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        int index = search(strings, "ball", 0 , strings.length - 1);
        System.out.println(index);
    }
}

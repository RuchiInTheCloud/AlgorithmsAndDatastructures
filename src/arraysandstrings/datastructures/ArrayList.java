package arraysandstrings.datastructures;

public class ArrayList<T> {
    private static final int INITIAL_CAPACITY = 4;

    T[] resizableArray;
    int size = 0;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        resizableArray = (T[]) new Object[size];
    }

    public void add(T element) {
        if (resizableArray.length == size) {
            doubleArraySize();
        }
        resizableArray[size++] = element;
    }

    public T get(int index) {
        return resizableArray[index];
    }

    private void doubleArraySize() {
        T[] tempArray = resizableArray;
        resizableArray = (T[]) new Object[tempArray.length * 2];
        int i = 0;
        for (T arrayElement : tempArray) {
            resizableArray[i] = tempArray[i];
            i++;
        }
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return resizableArray.length;
    }
}
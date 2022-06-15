package _3_arraysandstrings.datastructures;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 4;

    T[] resizableArray;
    int size = 0;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        resizableArray = (T[]) new Object[capacity];
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

    public T remove(int index) {
        T removedElement = resizableArray[index];
        for (int i = index; i < resizableArray.length - 1; i++) {
            resizableArray[i] = resizableArray[i + 1];
        }
        size--;
        return removedElement;
    }

    public void remove(T element) {
        for (int i = 0; i < resizableArray.length; i++) {
            if (element.equals(resizableArray[i])) {
                remove(i);
            }
        }
    }

    public void addAll(ArrayList<T> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            this.add(arrayList.get(i));
        }
    }

    public T[] toArray() {
        return resizableArray;
    }

    public void set(int index, T element) {
        resizableArray[index] = element;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            resizableArray[i] = null;
        }

        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < resizableArray.length - 1;
        }

        @Override
        public T next() {
            currentIndex++;
            return resizableArray[currentIndex];
        }
    }
}

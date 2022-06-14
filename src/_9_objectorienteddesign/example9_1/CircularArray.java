package _9_objectorienteddesign.example9_1;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
    T[] elements;
    int head = 0;

    public CircularArray(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if (i < 0 || i >= elements.length) {
            throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
        }
        return elements[convert(i)];
    }

    public void set(int index, T item) {
        elements[convert(index)] = item;
    }

    private int convert(int index) {
        if (index < 0) {
            index += elements.length;
        }
        return (head + index) % elements.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {
        int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < elements.length - 1;
        }

        @Override
        public T next() {
            currentIndex++;
            return elements[convert(currentIndex)];
        }
    }
}

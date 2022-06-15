package _9_objectorienteddesign.example11_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class Directory extends Entry {
    private ArrayList<Entry> contents;

    public Directory(String name, Directory parent) {
        super(name, parent);
        contents = new ArrayList<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry e : contents) {
            size += e.size();
        }
        return size;
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry e : contents) {
            if (e instanceof Directory) {
                count++; // Directory counts as a file
                Directory d = (Directory) e;
                count += d.numberOfFiles();
            } else if (e instanceof File) {
                count++;
            }
        }
        return count;
    }

    public void addEntry(Entry entry) {
        contents.add(entry);
    }

    public void removeEntry(Entry entry) {
        contents.remove(entry);
    }

    public ArrayList<Entry> getContents() {
        return contents;
    }
}

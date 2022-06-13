package _9_objectorienteddesign.example5_1;

import _3_arraysandstrings.datastructures.HashTable;

public class Library {
    private HashTable<Integer, Book> books;

    public void addBook(int id, String details) {
        if (!books.containsKey(id)) {
            Book book = new Book(id, details);
            books.put(book.getId(), book);
        }
    }

    public boolean remove(Book book) {
        return remove(book.getId());
    }

    public boolean remove(int id) {
        if (!books.containsKey(id)) {
            return false;
        }
        books.remove(id);
        return true;
    }

    public Book find(int id) {
        return books.get(id);
    }
}

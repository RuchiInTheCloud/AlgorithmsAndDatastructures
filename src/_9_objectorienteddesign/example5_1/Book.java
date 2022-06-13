package _9_objectorienteddesign.example5_1;

public class Book {
    private int id;
    private String details;

    public Book(int id, String details) {
        this.id = id;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

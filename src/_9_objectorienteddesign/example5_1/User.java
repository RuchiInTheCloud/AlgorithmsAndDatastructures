package _9_objectorienteddesign.example5_1;

public class User {
    private int id;
    private String details;
    private int accountType;

    public User(int id, String details, int accountType) {
        this.id = id;
        this.details = details;
        this.accountType = accountType;
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

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}

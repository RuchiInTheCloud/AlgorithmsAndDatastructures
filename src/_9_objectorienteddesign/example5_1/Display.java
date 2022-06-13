package _9_objectorienteddesign.example5_1;

public class Display {
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;

    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    public void displayBook(Book book) {
        pageNumber = 0;
        activeBook = book;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void turnPageForward() {
        pageNumber++;
        refreshPage();
    }

    public void turnPageBackward() {
        pageNumber--;
        refreshPage();
    }

    private void refreshUsername() {
        /* updates username display */
    }

    private void refreshTitle() {
        /* updates title display */
    }

    private void refreshDetails() {
        /* updates details display */
    }

    private void refreshPage() {
        /* updated page display */
    }
}

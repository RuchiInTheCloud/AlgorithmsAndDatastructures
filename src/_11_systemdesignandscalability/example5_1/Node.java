package _11_systemdesignandscalability.example5_1;

public class Node {
    public Node prev;
    public Node next;
    public String query;
    public String[] results;

    public Node(String query, String[] results) {
        this.query = query;
        this.results = results;
    }
}

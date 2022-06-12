package _9_objectorienteddesign.example2_1;

public enum Rank {
    Respondent(0),
    Manager(1),
    Director(2);

    private int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package _9_objectorienteddesign.example1_1;

public enum Suit {
    Club(0), Diamond(1), Heart(2), Spade(3);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public static Suit fromValue(int value) {
        switch (value){
            case 0: return Club;
            case 1: return Diamond;
            case 2: return Heart;
            case 3: return Spade;
            default: return null;
        }
    }
}

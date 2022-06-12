package _9_objectorienteddesign.example1_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class Hand<T extends Card> {
    ArrayList<T> cards = new ArrayList<>();

    public int score() {
        int score = 0;

        for (int i = 0; i < cards.size(); i++) {
            score += cards.get(i).value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void print() {
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).print();
        }
    }
}

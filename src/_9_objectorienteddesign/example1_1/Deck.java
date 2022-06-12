package _9_objectorienteddesign.example1_1;

import _3_arraysandstrings.datastructures.ArrayList;

import java.util.Random;

public class Deck<T extends Card> {
    ArrayList<T> cards;
    private int dealtIndex = 0;

    public void setDeckOfCards(ArrayList<T> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Random random = new Random();
        ArrayList<T> copy = new ArrayList<>();

        int oldDeckSize = cards.size();
        int randomIndex;
        while (oldDeckSize > 0) {
            randomIndex = random.nextInt(oldDeckSize);
            T card = cards.remove(randomIndex);
            copy.add(card);
            oldDeckSize = cards.size();
        }
        this.cards = copy;
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public T[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }

        T[] cardsToBeDealt = (T[]) new Card[number];

        for (int i = 0; i < number; i++) {
            T card = dealCard();
            if (card != null) {
                cardsToBeDealt[i] = card;
            }
        }
        return cardsToBeDealt;
    }

    public T dealCard() {
        if (remainingCards() == 0) {
            return null;
        }

        T cardToBeDealt = cards.get(dealtIndex);
        cardToBeDealt.markUnavailable();

        dealtIndex++;
        return cardToBeDealt;
    }
}

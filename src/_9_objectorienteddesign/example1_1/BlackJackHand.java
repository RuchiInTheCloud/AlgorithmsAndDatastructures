package _9_objectorienteddesign.example1_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {
    public int score() {
        ArrayList<Integer> possibleScores = possibleScores();
        int maxUnder = Integer.MAX_VALUE;
        int minOver = Integer.MIN_VALUE;

        for (int i = 0; i < possibleScores.size(); i++) {
            int score = possibleScores.get(i);
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }

        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores() {
        ArrayList<Integer> scores = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++) {
            addCardToScoresList(scores, cards.get(0));
        }

        return scores;
    }

    private void addCardToScoresList(ArrayList<Integer> scores, BlackJackCard card) {
        if (scores.size() == 0) {
            scores.add(0);
        }

        int length = scores.size();
        for (int i = 0; i < length; i++) {
            int score = scores.get(i);
            scores.set(i, score + card.minValue());
            if (card.minValue() != card.maxValue()){
                scores.add(score + card.maxValue());
            }
        }
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean is21() {
        return score() == 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        BlackJackCard first = cards.get(0);
        BlackJackCard second = cards.get(1);
        return (first.isAce() && second.isFaceCard()) || (second.isAce() && first.isFaceCard());
    }
}

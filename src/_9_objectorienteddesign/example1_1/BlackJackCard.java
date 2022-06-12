package _9_objectorienteddesign.example1_1;

public class BlackJackCard extends Card {
    public BlackJackCard(int faceValue, Suit suit) {
        super(faceValue, suit);
    }

    @Override
    public int value() {
        if (isAce())
            return 1;
        if (isFaceCard())
            return 10;
        else
            return faceValue;
    }

    public int minValue() {
        if (isAce()) {
            return 1;
        } else {
            return value();
        }
    }

    public int maxValue() {
        if (isAce()) {
            return 11;
        } else {
            return value();
        }
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }

    public boolean isAce() {
        return faceValue == 1;
    }
}

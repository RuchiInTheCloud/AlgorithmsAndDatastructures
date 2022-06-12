package _9_objectorienteddesign.fundamentals;

public class CardGame {
    enum GameType {Poker, BlackJack}

    public static CardGame createCardGame(GameType type) {
         if (type == GameType.Poker) {
             return new PokerGame();
         } else if (type == GameType.BlackJack) {
             return new BlackJackGame();
         }
         return null;
    }
}

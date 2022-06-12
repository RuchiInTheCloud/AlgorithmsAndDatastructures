package _9_objectorienteddesign.fundamentals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactoryMethodTest {
    @Test
    public void testFactoryMethod() {
        CardGame cardGame = CardGame.createCardGame(CardGame.GameType.Poker);
        assertEquals(cardGame.getClass(), PokerGame.class);

        cardGame = CardGame.createCardGame(CardGame.GameType.BlackJack);
        assertEquals(cardGame.getClass(), BlackJackGame.class);
    }
}

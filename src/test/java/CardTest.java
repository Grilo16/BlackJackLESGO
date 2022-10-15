import enums.CardRank;
import enums.CardSuit;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(CardSuit.HEARTS, CardRank.ACE);
    }

    @Test
    public void CardHasSuit() {
        assertEquals(CardSuit.HEARTS, card.getSuit());
    }

    @Test
    public void cardHasRank() {
        assertEquals(CardRank.ACE, card.getRank());
    }

    @Test
    public void cardHasValueArray() {
        assertEquals(2, card.getCardValues().length);
    }



}



import enums.CardRank;
import enums.CardSuit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;

    Card card1;
    Card card2;

    @Before
    public void before() {
        card1 = new Card(CardSuit.HEARTS, CardRank.ACE);
        card2 = new Card(CardSuit.CLUBS, CardRank.EIGHT);
        player = new Player("Shanda Leer");
    }

    @Test
    public void playerAsStartsAsPlayer() {
        assertEquals(false, player.isDealer());
    }

    @Test
    public void playerSetAsDealer() {
        player.setDealer();
        assertEquals(true, player.isDealer());
    }


    @Test
    public void playerStartsWithNoNormalCards() {
        assertEquals(0, player.getNormalCards().size());
    }

    @Test
    public void playerStartsWithNoAces() {
        assertEquals(0, player.getAces().size());
    }

    @Test
    public void playerScoreStartsAt0() {
        assertEquals(0, player.getScore());
    }

    @Test
    public void playerCanGetTotalCards() {
        player.addNewCard(card1);
        player.addNewCard(card2);
        assertEquals(2, player.getTotalCards());
    }

    @Test
    public void playerCanGetTotalCardsList() {
        player.addNewCard(card1);
        player.addNewCard(card2);
        assertEquals(2, player.getAllCards().size());
    }

    @Test
    public void playersNormalCardsSeparate() {
        player.addNewCard(card1);
        player.addNewCard(card2);
        assertEquals(1, player.getNormalCards().size());
    }

    @Test
    public void playersAcesSeparate() {
        player.addNewCard(card1);
        player.addNewCard(card2);
        assertEquals(1, player.getAces().size());
    }

    @Test
    public void playerScoreUpdatesBasedOnCards() {
        player.addNewCard(card1);
        player.addNewCard(card2);
        assertEquals(19, player.getScore());
    }

    @Test
    public void aceGoesLowIfScoreAbove11() {
        player.addNewCard(card1);
        player.addNewCard(card1);
        player.addNewCard(card2);
        assertEquals(20, player.getScore());
    }

    @Test
    public void testCanClearCards() {
        player.addNewCard(card1);
        player.addNewCard(card1);
        player.addNewCard(card2);
        player.clearCards();
        assertEquals(0, player.getTotalCards());
    }
}

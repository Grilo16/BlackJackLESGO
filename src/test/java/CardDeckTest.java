import enums.CardRank;
import enums.CardSuit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardDeckTest {
    CardDeck cardDeck;
    Card firstCard;
    Card lastCard;


    @Before
    public void before() {
        cardDeck = new CardDeck();
        firstCard = new Card(CardSuit.HEARTS, CardRank.ACE);
        lastCard = new Card(CardSuit.SPADES, CardRank.KING);
    }

    @Test
    public void has52CardsInDeck() {
        assertEquals(52, cardDeck.getCards().size());
    }

    @Test
    public void deckStartsOrderedFirstCardKnown() {
        assertEquals(firstCard.getRank(), cardDeck.getCards().get(0).getRank());

    }

    @Test
    public void deckStartsOrderedlastCardKnown() {
        assertEquals(lastCard.getRank(), cardDeck.getCards()
                .get(cardDeck.getCards().size()-1).getRank());
    }

    @Test
    public void DeckCanBeShuffled() {
        CardDeck shuffled = new CardDeck();
        shuffled.shuffleDeck();
        int index = 0;
        for (Card card: cardDeck.getCards()){
            if (card.getRank() == shuffled.getCards().get(index).getRank()){
            index ++;
            }else{
                boolean equalAtSameIndex = (card.getRank() == shuffled.getCards().get(index).getRank());
                assertEquals(false, equalAtSameIndex);
                break;
            }
        }

    }

    @Test
    public void DeckDealsTopCard() {
        Card dealtCard = cardDeck.dealTopCard();
        assertEquals(firstCard.getRank(), dealtCard.getRank());
    }

    @Test
    public void arrayLosesCardDealt() {
        cardDeck.dealTopCard();
        assertEquals(51, cardDeck.getCards().size());
    }
}

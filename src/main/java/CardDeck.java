import enums.CardRank;
import enums.CardSuit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CardDeck {
    private ArrayList<Card> cardDeck;

    public CardDeck() {
        cardDeck = new ArrayList<>();
        CardSuit[] suits = CardSuit.values();
        CardRank[] ranks = CardRank.values();
        for (CardSuit suit: suits){
            for (CardRank rank : ranks){
                Card card = new Card(suit, rank);
                cardDeck.add(card);
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cardDeck;
    }

    public void shuffleDeck(){

        Collections.shuffle(this.cardDeck);

    }

    public void setCardDeck(ArrayList<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public Card dealTopCard() {
        Card cardToDeal = this.cardDeck.get(0);
        this.cardDeck.remove(0);
        return cardToDeal;
    }
}

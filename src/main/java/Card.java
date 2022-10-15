import enums.CardRank;
import enums.CardSuit;

public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;

    private int[] cardValues;

    public Card(CardSuit cardSuit, CardRank cardRank){
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
        this.cardValues = cardRank.getValues();
    }

    public CardSuit getSuit() {
        return this.cardSuit;
    }

    public CardRank getRank() {
        return this.cardRank;
    }

    @Override
    public String toString() {
        return this.cardRank +" of " + this.cardSuit;
    }

    public int[] getCardValues() {
        return this.cardValues;
    }
}

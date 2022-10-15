import enums.CardRank;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> normalCards;
    private ArrayList<Card> aces;
    private ArrayList<Card> allCards;

    private int score;
    private boolean dealer;

    public Player(String name) {
        this.allCards = new ArrayList<>();
        this.normalCards = new ArrayList<>();
        this.aces = new ArrayList<>();
        this.name = name;
        this.score = 0;
        this.dealer = false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getAllCards() {
        return this.allCards;
    }

    public ArrayList<Card> getNormalCards() {
        return this.normalCards;
    }
    public ArrayList<Card> getAces() {
        return this.aces;
    }

    public int getScore() {
        return this.score;
    }
    public void addNewCard(Card card){
        allCards.add(card);

        if (card.getRank() == CardRank.ACE){
            this.aces.add(card);
        }else{
            this.normalCards.add(card);
        }
        this.updateScore();

    }

    public void updateScore() {
        int newScore = 0;
        for (Card card : this.normalCards) {
            newScore += card.getCardValues()[0];
        }
        for (Card card : this.aces) {
            if (newScore >= 11) {
                newScore += card.getCardValues()[0];
            } else {
                newScore += card.getCardValues()[1];
            }
        }
        this.score = newScore;
    }

    public void setDealer(){
        this.dealer = true;
    }
    public boolean isDealer() {
        return this.dealer;
    }

    public int getTotalCards() {
        return this.aces.size() + this.normalCards.size();
    }

    public void clearCards(){
        this.normalCards.clear();
        this.aces.clear();
        this.allCards.clear();
    }

    @Override
    public String toString() {
        return "Player: "+ this.name +"\nCards:"+ this.allCards +"\nCurrent score: "+ this.score + "\n\n";
    }
}

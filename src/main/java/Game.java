import enums.CardRank;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private CardDeck deck;
    private ArrayList<Player> players;
    private  Player dealer;

    public Game(CardDeck deck) {
        this.players = new ArrayList<>();
        this.deck = deck;
        this.dealer = new Player("dealer");
        this.dealer.setDealer();
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
    public Player getDealer() {
        return this.dealer;
    }

    public CardDeck getDeck() {
        return this.deck;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void dealStartingCards(){
        for (int i = 0; i<2; i++){
            dealer.addNewCard(deck.dealTopCard());
            for (Player player : players){
                player.addNewCard(deck.dealTopCard());
            }
        }
    }

    public int getDeckSize() {
        return deck.getCards().size();
    }

    public boolean checkBlackJack(Player player) {
        return player.getScore() == 21 && player.getTotalCards() == 2;
    }

    public boolean checkNotBusted(Player player) {
        return player.getScore() <= 21;
    }

    public void drawACard(Player player) {
        player.addNewCard(this.deck.dealTopCard());
    }

    public void dealerMove() {
        while (true){
            if (this.deck.getCards().size() < 1){
                break;
            }
            if (this.dealer.getScore() > 16){
            System.out.println(this.dealer);
                break;
            }else{
            System.out.println(this.dealer);
                this.drawACard(this.dealer);
            }
        }
    }

    public Player declareWinner() {
        ArrayList<Player> competing = new ArrayList<>();
        Player winner = null;

        if (this.checkBlackJack(this.dealer)){
            return this.dealer;
        }else if(this.checkNotBusted(this.dealer)){
            competing.add(this.dealer);
        }

        for (Player player: this.players){
            if (this.checkBlackJack(player)){
                return player;
            }else if(this.checkNotBusted(player)){
                competing.add(player);
            }
        }
        if (competing.size() > 0){

        for (Player player: competing){
            if (winner == null){
                winner = player;
            }else{
                if (player.getScore() > winner.getScore()){
                    winner = player;
                }
            }
        }
        return winner;
        }
        return null;
    }
    public Card showOneDealerCard() {
        return this.dealer.getAllCards().get(0);
    }


}

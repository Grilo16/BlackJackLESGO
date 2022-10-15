import enums.CardRank;
import enums.CardSuit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    Game game;
    CardDeck deck;
    Player player1;
    Player player2;

    Card ace;
    Card king;
    Card nine;



    @Before
    public void before(){
        deck = new CardDeck();
        player1 = new Player("Shanda Leer");
        player2 = new Player("Ducky");
        game = new Game(deck);
        ace = new Card(CardSuit.SPADES, CardRank.ACE);
        king = new Card(CardSuit.SPADES, CardRank.KING);
        nine = new Card(CardSuit.SPADES, CardRank.NINE);
    }

    @Test
    public void gameHas52CardDeck() {
        assertEquals(52, game.getDeckSize());
    }

    @Test
    public void checkGetDeckWorks() {
        assertEquals(52, game.getDeck().getCards().size());
    }

    @Test
    public void gameHasADealer() {
        Player dealer = game.getDealer();
        assertEquals(true, dealer.isDealer());
    }

    @Test
    public void gameHasNoPlayers() {
        assertEquals(0, game.getPlayers().size());
    }

    @Test
    public void gameCanAddPlayers() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(2, game.getPlayers().size());
    }

    @Test
    public void gameCanDealCards() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.dealStartingCards();
        assertEquals(46, game.getDeckSize());
    }

    @Test
    public void checkBlackJackTrue() {
        Player player = new Player("Lucky");
        player.addNewCard(ace);
        player.addNewCard(king);
        assertEquals(true, game.checkBlackJack(player));

    }

    @Test
    public void checkBlackJackFalse() {
        Player player = new Player("not so Lucky");
        player.addNewCard(ace);
        player.addNewCard(nine);
        assertEquals(false, game.checkBlackJack(player));
    }

    @Test
    public void checkBustedTrue() {
        Player player = new Player("not so Lucky");
        player.addNewCard(ace);
        player.addNewCard(nine);
        player.addNewCard(nine);
        player.addNewCard(nine);
        assertEquals(false, game.checkNotBusted(player));
    }

    @Test
    public void checkBustedFalse() {
        Player player = new Player("still Lucky");
        player.addNewCard(ace);
        player.addNewCard(ace);
        player.addNewCard(nine);
        assertEquals(true, game.checkNotBusted(player));
    }

    @Test
    public void playerDrawCard() {
        Player player = new Player("still Lucky");
        game.drawACard(player);
        assertEquals(51, game.getDeckSize());
        assertEquals(1, player.getTotalCards());
    }

    @Test
    public void DealerMoveLessThan16() {
        game.dealerMove();
        assertEquals(4, game.getDealer().getTotalCards());
    }

    @Test
    public void DealerMoveMoreThan16() {
        game.getDealer().addNewCard(nine);
        game.getDealer().addNewCard(nine);
        game.dealerMove();
        assertEquals(2, game.getDealer().getTotalCards());
    }

    @Test
    public void getWinner() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.dealStartingCards();
        game.dealerMove();
        Player winner = game.declareWinner();
        assertEquals(game.getDealer().getName(), winner.getName());
    }

    @Test
    public void dealerShowFirstCard() {
        game.dealStartingCards();
        assertEquals(ace.getRank(), game.showOneDealerCard().getRank());

    }
}

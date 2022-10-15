import java.util.Objects;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        Game game = new Game(deck);
        Player ducky = new Player("Ducky");
        Player shanda = new Player("Shanda Leer");
        game.addPlayer(ducky);
        game.addPlayer(shanda);

        game.getDeck().shuffleDeck();

//        Start Game
        while(true){
            game.dealStartingCards();
                for (Player player: game.getPlayers()){
//                    Player Turn
                    while(true){
                        if (game.getDeck().getCards().size() < 1){
                            System.out.println("no more cards in the deck");
                            break;
                        }
                System.out.printf("Dealer's card: %s \n\n", game.showOneDealerCard());
                    System.out.println(player);
                        System.out.println("Twist or Stand?");

                        Scanner in = new Scanner(System.in);
                        String userInput = in.nextLine();

                        if (Objects.equals(userInput, "Twist")) {
                            game.drawACard(player);
                            if (!game.checkNotBusted(player)){
                                System.out.println(player);
                                System.out.println("Sorry you have busted");
                                in.nextLine();
                                break;
                            }
                        }else if (Objects.equals(userInput, "Stand")){
                            break;
                        }
                    }
                }
                game.dealerMove();
            Player winner = game.declareWinner();
            if (winner != null){
            System.out.printf("Winner: %s\nScore: %s\nCards: %s", winner.getName(), winner.getScore(), winner.getAllCards());
            }else{
                System.out.println("No winner");
            }


//            Clear everybody cards
            game.getDealer().clearCards();
            for (Player player: game.getPlayers()){
                player.clearCards();
            }


            System.out.println("\nType 'Done' to finish game, anything else for another round");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();
            if (Objects.equals(userInput, "Done")) {
                System.out.println("Game is finished, Thank you for playing");
                break;
            }
                System.out.println("\nStarting new round\n");

            if (game.getDeck().getCards().size() < (game.getPlayers().size() +1) *2){
                System.out.println("\nDeck finished, thank you for playing\n");
                break;

            }
        }
    }
}

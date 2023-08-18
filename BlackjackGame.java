// Importing necessary classes
package Deliverable3;
import java.util.Scanner;

// Definition of the BlackjackGame class, extending the Game class
public class BlackjackGame extends Game {

    // Private member variables to hold the deck, player, and dealer
    private final GroupOfCards deck;
    private final BlackjackPlayer player;
    private final Dealer dealer;

    // Constructor for initializing the game with a name and deck
    public BlackjackGame(String name, GroupOfCards deck) {
        super(name);
        this.deck = deck;
        this.player = new BlackjackPlayer("Player");
        this.dealer = new Dealer();
    }

    // Getter methods for accessing player and dealer
    public BlackjackPlayer getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    // Private method to deal the initial cards to player and dealer
    private void dealStartingCards() {
        player.addToHand(deck.getCards().remove(0));
        dealer.addToHand(deck.getCards().remove(0));
        player.addToHand(deck.getCards().remove(0));
        dealer.addToHand(deck.getCards().remove(0));
    }

    // Overriding the play method from the parent class
    @Override
    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");


    }

    // Method to declare the winner based on hand values
    public void declareWinner() {
        int maxScore = 0;
        Player winner = null;

        for (Player player : getPlayers()) {
            int playerScore = player.getHandValue();
            if (playerScore <= 21 && playerScore > maxScore) {
                maxScore = playerScore;
                winner = player;
            }
        }

        // Displaying the winner or a message if all players busted
        if (winner != null) {
            System.out.println("\n" + winner.getName() + " wins with a hand value of " + maxScore + "!");
        } else {
            System.out.println("\nNo winner. All players busted!");
        }
    }
}

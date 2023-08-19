package Deliverable3;

import java.util.Scanner;

public class BlackjackGame extends Game {

    private final GroupOfCards deck;  // The deck of cards used in the game.
    private final BlackjackPlayer player;  // The player participating in the game.
    private final Dealer dealer;  // The dealer managing the game.

    public BlackjackGame(String name, GroupOfCards deck) {
        super(name);  // Initialize the base class with the provided name.
        this.deck = deck;  // Set the deck for the game.
        this.player = new BlackjackPlayer("Player");  // Create a new player with a default name.
        this.dealer = new Dealer();  // Create a dealer instance.
    }

    public BlackjackPlayer getPlayer() {
        return player;  // Return the player instance.
    }

    public Dealer getDealer() {
        return dealer;  // Return the dealer instance.
    }

    private void dealStartingCards() {
        // Deal two cards to both the player and the dealer at the beginning of the round.
        player.addToHand(deck.getCards().remove(0));
        dealer.addToHand(deck.getCards().remove(0));
        player.addToHand(deck.getCards().remove(0));
        dealer.addToHand(deck.getCards().remove(0));
    }

    @Override
    public void play() {
        Scanner input = new Scanner(System.in);  // Create a Scanner instance for user input.
        System.out.println("Welcome to Blackjack!");

        do {
            startNewRound();  // Start a new round of the game.

            // Player's turn
            playerTurn(input);  // Allow the player to make their decisions.

            // Dealer's turn
            dealerTurn();  // Allow the dealer to play its turn.

            // Determine the winner and display the result
            determineWinner();  // Determine the winner of the round.

            // Prompt the player to play again
        } while (playAgain(input));  // Check if the player wants to play another round.

        input.close();  // Close the Scanner instance.
    }

    @Override
    public void declareWinner() {
        // To be implemented: Display the winner of the game.
    }

    private void startNewRound() {
        deck.shuffle();  // Shuffle the deck for a new round.
        player.resetHand();  // Reset the player's hand for a new round.
        dealer.resetHand();  // Reset the dealer's hand for a new round.
        dealStartingCards();  // Deal starting cards to the player and dealer.
    }

    private void playerTurn(Scanner input) {
        while (player.getHandValue() < 21) {
            displayGameState(dealer, player);  // Display the current game state.
            System.out.print("Do you want to Hit (H) or Stand (S)? ");

            String playerChoice = input.nextLine();

            if (playerChoice.equalsIgnoreCase("H")) {
                player.addToHand(deck.getCards().remove(0));  // Add a card to the player's hand.
            } else if (playerChoice.equalsIgnoreCase("S")) {
                break;  // Player chooses to stand, ending their turn.
            } else {
                System.out.println("Invalid choice");  // Display an error message for invalid input.
            }
        }
    }

    private void dealerTurn() {
        while (dealer.getHandValue() < 17) {
            dealer.addToHand(deck.getCards().remove(0));  // Dealer hits as long as hand value is less than 17.
        }
    }

    private void determineWinner() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        displayGameState(dealer, player);  // Display the final game state.

        if (playerValue > 21) {
            System.out.println("You went bust! Dealer wins.");  // Player's hand value exceeds 21.
        } else if (dealerValue > 21) {
            System.out.println("Dealer went bust! You win.");  // Dealer's hand value exceeds 21.
        } else if (playerValue == dealerValue) {
            System.out.println("It's a tie!");  // Both player and dealer have the same hand value.
        } else if (playerValue > dealerValue) {
            System.out.println("You win!");  // Player's hand value is greater than dealer's.
        } else {
            System.out.println("Dealer wins.");  // Dealer's hand value is greater than player's.
        }
    }

    private boolean playAgain(Scanner input) {
        System.out.print("Do you want to play again? (Y/N) ");
        String playAgainChoice = input.nextLine();
        return playAgainChoice.equalsIgnoreCase("Y");  // Check if player wants to play another round.
    }

    private void displayGameState(Dealer dealer, BlackjackPlayer player) {
        System.out.println("Your hand: " + player.getHand() + " (Value: " + player.getHandValue() + ")");
        System.out.println("Dealer's hand: " + dealer.getHand() + " (Value: " + dealer.getHandValue() + ")");
    }
}

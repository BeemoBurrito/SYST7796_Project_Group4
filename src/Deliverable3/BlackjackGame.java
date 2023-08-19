package Deliverable3;

import java.util.Scanner;

public class BlackjackGame extends Game {

    private final GroupOfCards deck;
    private final BlackjackPlayer player;
    private final Dealer dealer;

    public BlackjackGame(String name, GroupOfCards deck) {
        super(name);
        this.deck = deck;
        this.player = new BlackjackPlayer("Player");
        this.dealer = new Dealer();
    }

    public BlackjackPlayer getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    private void dealStartingCards() {
        player.addToHand(deck.getCards().remove(0));
        dealer.addToHand(deck.getCards().remove(0));
        player.addToHand(deck.getCards().remove(0));
        dealer.addToHand(deck.getCards().remove(0));
    }

    @Override
    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");

        do {
            startNewRound();

            // Player's turn
            playerTurn(input);

            // Dealer's turn
            dealerTurn();

            // Determine the winner and display the result
            determineWinner();

            // Prompt the player to play again
        } while (playAgain(input));

        input.close();
    }

    @Override
    public void declareWinner() {

    }

    private void startNewRound() {
        deck.shuffle();
        player.resetHand();
        dealer.resetHand();
        dealStartingCards();
    }

    private void playerTurn(Scanner input) {
        while (player.getHandValue() < 21) {
            displayGameState(dealer, player);
            System.out.print("Do you want to Hit (H) or Stand (S)? ");

            String playerChoice = input.nextLine();

            if (playerChoice.equalsIgnoreCase("H")) {
                player.addToHand(deck.getCards().remove(0));
            } else if (playerChoice.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    private void dealerTurn() {
        while (dealer.getHandValue() < 17) {
            dealer.addToHand(deck.getCards().remove(0));
        }
    }

    private void determineWinner() {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        displayGameState(dealer, player);

        if (playerValue > 21) {
            System.out.println("You went bust! Dealer wins.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer went bust! You win.");
        } else if (playerValue == dealerValue) {
            System.out.println("It's a tie!");
        } else if (playerValue > dealerValue) {
            System.out.println("You win!");
        } else {
            System.out.println("Dealer wins.");
        }
    }

    private boolean playAgain(Scanner input) {
        System.out.print("Do you want to play again? (Y/N) ");
        String playAgainChoice = input.nextLine();
        return playAgainChoice.equalsIgnoreCase("Y");
    }

    private void displayGameState(Dealer dealer, BlackjackPlayer player) {
        System.out.println("Your hand: " + player.getHand() + " (Value: " + player.getHandValue() + ")");
        System.out.println("Dealer's hand: " + dealer.getHand() + " (Value: " + dealer.getHandValue() + ")");
    }
}

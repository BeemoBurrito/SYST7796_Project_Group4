// Importing necessary classes
package Deliverable3;
import java.util.ArrayList;
import java.util.List;

// Definition of the BlackjackPlayer class, extending the Player class
public class BlackjackPlayer extends Player {

    // Private member variable to store the player's hand
    private final List<Card> hand;

    // Constructor for initializing the player with a name
    public BlackjackPlayer(String name) {
        super(name); // Pass the player's name to the superclass constructor
        this.hand = new ArrayList<>(); // Initialize the player's hand as an empty ArrayList
    }

    // Method to add a card to the player's hand
    public void addToHand(Card card) {
        hand.add(card);
    }

    // Method to get the player's current hand
    public List<Card> getHand() {
        return hand;
    }

    // Method to calculate the value of the player's hand
    public int getHandValue() {
        int value = 0;
        int aces = 0;

        // Loop through each card in the player's hand
        for (Card card : hand) {
            int cardValue = card.getValue();
            value += cardValue;
            if (cardValue == 11) {
                aces++; // Count the number of Aces in the hand
            }
        }

        // Adjust the value if there are Aces and the total value is over 21
        while (value > 21 && aces > 0) {
            value -= 10; // Convert an Ace from 11 to 1
            aces--;
        }

        return value; // Return the calculated value of the hand
    }

    // Method to reset the player's hand
    public void resetHand() {
        hand.clear(); // Clear the player's hand
    }

    // Overriding the toString() method to display the player's name and hand
    @Override
    public String toString() {
        return getName() + "'s Hand: " + hand; // Use getName() to get the player's name
    }

    // Overriding the play() method from the parent class
    @Override
    public void play() {
        // Implement the player's play logic here
        // You may want to add more code to handle the player's actions during the game.
    }
}

// Importing necessary classes
package Deliverable3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definition of the GroupOfCards class, extending the Card class
public class GroupOfCards extends Card {

    // Private member variables to store cards and size
    private final List<Card> cards;
    private int size;

    // Constructor for initializing the group of cards with a specific size
    public GroupOfCards(int size) {
        super(); // Call the constructor of the superclass (Card)
        this.size = size;
        cards = createDeck(); // Create and initialize the deck of cards
        shuffle(); // Shuffle the deck upon creation
    }

    // Private method to create a standard deck of cards
    private List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Generate cards for each suit and rank combination
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank) {
                    @Override
                    public String toString() {
                        return rank + " of " + suit;
                    }

                    @Override
                    public int getValue() {
                        if (rank.equals("A")) {
                            return 11;
                        } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
                            return 10;
                        } else {
                            return Integer.parseInt(rank);
                        }
                    }
                });
            }
        }

        return deck; // Return the created deck
    }

    // Method to shuffle the cards in the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to get the list of cards in the deck
    public List<Card> getCards() {
        return cards;
    }

    // Getter method for the size of the deck
    public int getSize() {
        return size;
    }

    // Setter method to update the size of the deck
    public void setSize(int size) {
        this.size = size;
    }

    // Overriding the toString() method to provide a description of the deck
    @Override
    public String toString() {
        return "Deck of " + size + " cards";
    }
}

package Deliverable3;

import java.util.ArrayList;
import java.util.List;

public class BlackjackPlayer extends Player {

    private final List<Card> hand;

    public BlackjackPlayer(String name) {
        super(name); // Pass the player's name to the superclass constructor
        this.hand = new ArrayList<>();
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandValue() {

    }

    public void resetHand() {
        hand.clear();
    }

    @Override
    public String toString() {
        return getName() + "'s Hand: " + hand; // Use getName() to get the player's name
    }

    @Override
    public void play() {
        // Implement the player's play logic here
        // You may want to add more code to handle the player's actions during the game.
    }
}

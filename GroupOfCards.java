package Deliverable3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupOfCards extends Card {

    private final List<Card> cards;
    private int size;

    public GroupOfCards(int size) {
        super();
        this.size = size;
        cards = createDeck();
        shuffle();
    }



    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Deck of " + size + " cards";
    }
}


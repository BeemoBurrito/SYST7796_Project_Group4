/**/
package Deliverable3;

public class Main {

    public static void main(String[] args) {
        GroupOfCards deck = new GroupOfCards(52);
        BlackjackGame blackjackGame = new BlackjackGame("Blackjack", deck);

        blackjackGame.getPlayers().add(blackjackGame.getPlayer());
        blackjackGame.getPlayers().add(blackjackGame.getDealer());

        blackjackGame.play();
        blackjackGame.declareWinner();
    }
}
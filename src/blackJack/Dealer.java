package blackJack;

import java.util.Collections;

public class Dealer extends Player {
	Deck deck = new Deck();
	Hand hand = new Hand();
	
	
	public void shuffleDeck(){
		deck.createDeck();
		
		Collections.shuffle(deck.getDeck());
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Card deal() {
	
		return deck.getDeck().remove(0);
	}
}

	
	


package main;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Integer> deck;

	public Deck() {
		reset();
	}
	
	public Deck(ArrayList<Integer> deck) {
		this.deck = deck;
	}

	public void reset() {
		deck = new ArrayList<Integer>(52);

		for (int i = 0; i < 52; i++) {
			deck.add(i + 1);
		}
	}
	
	public ArrayList<Integer> deal(int num, boolean bottomdeal) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		num = Math.min(num, deck.size());
		
		for (int i = 0; i < num; i++) {
			output.add(deck.remove(0));
		}
		
		return output;
	}

	public ArrayList<Integer> getDeck() {
		return deck;
	}
	
	public void setDeck(ArrayList<Integer> deck) {
		this.deck = deck;
	}

	public String toString() {
		return deck.toString();
	}
}

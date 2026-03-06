package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements Comparable {
	private ArrayList<Integer> deck;

	public Deck() {
		reset();
	}

	public Deck(ArrayList<Integer> deck) {
		this.deck = deck;
	}
	
	public int addCards(ArrayList<Integer> moreCards) {
		int count = 0;
		
		for (int i = 0; i < moreCards.size(); i ++ ) {
			if (!deck.contains(moreCards.get(i))) {
				deck.add(moreCards.get(i));
				count++;
			}
		}
		
		return count;
	}

	public ArrayList<Integer> deal(ArrayList<Integer> tempDeck, int num, boolean bottomdeal) {
		num = Math.min(num, tempDeck.size());
		
		ArrayList<Integer> output = new ArrayList<Integer>(num);

		for (int i = 0; i < num; i++) {
			if (bottomdeal) {
				output.add(tempDeck.remove(tempDeck.size() - 1));
			} else {
				output.add(tempDeck.remove(0));
			}
		}
		return output;
	}
	
	public ArrayList<Integer> deal(int num, boolean bottomdeal) {
		return deal(deck, num, bottomdeal);
	}
	
	public boolean cut(int cutSpot) {
		if (cutSpot > deck.size() - 1 || cutSpot < 0) {
			return false;
		}
		deck.addAll(deal(cutSpot + 1, false));
		
		return true;
	}
	
	public void reset() {
		deck = new ArrayList<Integer>(52);

		for (int i = 0; i < 52; i++) {
			deck.add(i + 1);
		}
	}
	
	public void shuffleRandom(int count, boolean show) {
		for (int i = 0; i < count; i++) {
			int bottomSize = (int) (Math.random() * deck.size()/2);
			ArrayList<Integer> bottomDeck = deal(bottomSize, true);
			
			ArrayList<Integer> tempDraw;
			if (bottomDeck.size() >= 7) {
				tempDraw = deal(bottomDeck, (int) (Math.random() * 4) + 3, false);
			} else {
				tempDraw = deal(bottomDeck, bottomDeck.size(), false);
			}
			deck.addAll(tempDraw);
		}
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

	@Override
	public int compareTo(Object deck2) {
		if (!(deck2 instanceof Deck)) {
			return -1;
		}
		
		int count = 0;
		
		for (int i = 0; i < deck.size(); i ++) {
			if (deck.get(i) == ((Deck) (deck2)).getDeck().get(i)) {
				count++;
			}
		}
		if (count == deck.size()) {
			return 0;
		}
		
		Collections.sort((ArrayList<Integer>) (deck2));
		ArrayList<Integer> temp = deck;
		Collections.sort(deck);
		ArrayList<Integer> sortedDeck = temp;
		deck = temp;
		
		if (sortedDeck.equals(deck2)) {
			return 1;
		}

		return -1;
	}
}

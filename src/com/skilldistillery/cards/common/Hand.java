package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cards = new ArrayList<>();

	public void addCard(Card card) {
		cards.add(card);
	}

	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}

	public void fold() {
		cards.clear();
	}

	public void displayHand() {
		if (cards.size() == 0) {
			System.out.println("\n No cards \n");
		} else {
			for (Card card : cards) {
				System.out.println(card);
			}
		}
	}
	
	public void displaySingleCardFromHand() {
		System.out.println("\n"+cards.get(1)+"\n");
	}
}
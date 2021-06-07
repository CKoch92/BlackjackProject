package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BlackjackApp app = new BlackjackApp();
		Deck deck = new Deck();
		boolean playAgain = true;
		
		while (playAgain) {
			playAgain = app.launch(input, deck);
		}
		input.close();
	}

	private boolean launch(Scanner input, Deck deck) {
		boolean playAgain = false;
//		Write a program to ask a user how many cards they want.
		try {
//		Handle the case where users enter a non-integer or a number greater than 52: print an error message.
			System.out.print("Would you like to play blackjack? ");
			String playResponse = input.next();
//			if (!playResponse.equalsIgnoreCase("yes") || !playResponse.equalsIgnoreCase("no")) {
//				throw new InputMismatchException("Please reply either yes or no. Start over");
//			}
		}
		catch (InputMismatchException e) {
			System.err.println(e);
//			return;
		}
//		catch (RuntimeException re) {
//			System.err.println(re);
//			return;
//		}
		deck.shuffle();
		
		BlackjackHand userHand = new BlackjackHand();
		BlackjackHand dealerHand = new BlackjackHand();
		for(int i = 0; i < 2; i++) {
			userHand.addCard(deck.dealCard());
			dealerHand.addCard(deck.dealCard());
		}
		System.out.println("Dealer Hand:");
		dealerHand.displaySingleCardFromHand();
		
		System.out.println("Your Hand value: " + userHand.getHandValue());
		userHand.displayHand();
		boolean keepPlaying = true;
		boolean dealerHit = true;
		while (keepPlaying) {
			if(userHand.getHandValue() == 21) {
				System.out.println("You have BlackJack! Do not hit!");
				keepPlaying = false;
			}
			System.out.println();
			System.out.println("Hit or hold? ");
			String hitOrHold = input.next();
			if (hitOrHold.equalsIgnoreCase("hit")) {
				userHand.addCard(deck.dealCard());
				System.out.println();
				System.out.println("Your hand contains: ");
				userHand.displayHand();
				System.out.println("Hand value: " + userHand.getHandValue());
					if (userHand.getHandValue()>21) {
						System.out.println();
						System.out.println("Your hand has exceeded 21. You have busted.");
						keepPlaying = false;
					}
			}
			if (hitOrHold.equalsIgnoreCase("hold")) {
				keepPlaying = false;
			}
			
		}
		while (dealerHit) {
			if(userHand.getHandValue() > 21) {
				dealerHit = false;
			}
			else if (dealerHand.getHandValue() < 17) {
				dealerHand.addCard(deck.dealCard());
			}
			else {
				dealerHit = false;
			}
		}
		
		System.out.println();
		System.out.println("Dealer: ");
		dealerHand.displayHand();
		System.out.println(dealerHand.getHandValue());
		System.out.println();
		System.out.println();
		System.out.println("You: " + userHand.getHandValue());
		System.out.println();
		
		if ((userHand.getHandValue()>dealerHand.getHandValue() && userHand.getHandValue()<=21) || userHand.getHandValue()<=21 && dealerHand.getHandValue()>21) {
			System.out.println("Congratulations you won! Play again?");
		}
		else if (userHand.getHandValue()==dealerHand.getHandValue()) {
			System.out.println("You drew with the dealer. Play again?");
		}
		else {
			System.out.println("You lost this round. Play again?");
		}
		
		String anotherGame = input.next();
		if (anotherGame.equalsIgnoreCase("yes") || anotherGame.equalsIgnoreCase("y")) {
			playAgain = true;
		}
		else {
			playAgain = false;
		}
		
		return playAgain;

	}
}
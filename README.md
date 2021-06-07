## Blackjack Project

* User-view:
User is asked if they want to play. If so, they are given two cards and shown one of the dealer's cards. If the user has a card value of 21, they automatically win. If the card value is not 21, user is prompted to hit or hold. Holding will keep card value where it is. Hitting will give the user another card from the deck. User will be asked to hit or hold, until they hold. Once hold has been typed into the program, the dealer's deck is shown and compared to the user's deck. If the user's deck has a value 21 or under AND exceeds the value of the dealer's deck, the user wins. If the value is equal, the user ties, and if the value is less, the dealer wins.


* Methodology:
At the core of the project, a card is created with a rank and suit value. The rank and suit values each generated from enums in separate classes. A Deck Class creates an ArrayList of cards, and uses nested for loops to create a card of each potential value.

This leads to the collection of a deck which is then shuffled using the collection.shuffle() method. After shuffling, two cards are removed form the deck and given to the user and the dealer in their own instantiated decks. Each deck calls on the cards' getValue() and displays the user's value of their hand.

A while loop is made and set to true (keepPlaying) and a number of if conditions are set within the loop. If the user's card value == 21, the loop breaks and the user wins. If not, the user is prompted, via scanner, to get another card. If yes ("hit"), another card is removed from the top of the Deck ArrayList and added to the user's hand. keepPlaying still equals true, so the user is prompted once again to hit or hold.

If the user selects hold, keepPlaying becomes false and the while loop is broken. A new while loop begins in which the dealer choose whether or not to add to their hand. If the dealer's hand value is less than 17, they will add another card from the deck ArrayList. Once the hand value reaches 17, they will hold. and the new while loop boolean (dealerHit is turned to false).

User and dealer hand values are displayed and compared. An if, else if, else statement compares the values and generates statements for a user win, draw, or loss. The user is prompted to play again, and a yes or y response maintains a true value of keepPlaying. If not, a false value is generated. Either value is returned through the run method. If a true value is returned, the method is called again through the main's while loop, until the user decides not to play again.

* Lessons Learned

This is not so much a lesson's learned as it is a confusing missed opportunities section. The biggest problem I had was encapsulation and taking the logic into different class. When I tried, via BlackjackHand and Dealer, I struggled to call them in BlackjackApp. As a result, the code is a bit sloppy and congested in the app's run method. I'd definitely like to walkthrough how to clean up the code with an instructor later this week. I thought I understood it, but it was certainly a case of trial and error, in which I resorted back to putting the logic in the BlackjackApp to keep the program functional.

package blackJack;

import java.util.Scanner;

public class Game {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Dealer dealer = new Dealer();
		dealer.shuffleDeck();
		Player player = new Player();
		player.getHand().add(dealer.deal());
		dealer.getHand().add(dealer.deal());
		player.getHand().add(dealer.deal());
		dealer.getHand().add(dealer.deal());
		showPlayerCards(player);
		System.out.println("****Player has " + playerTotal(player));
		showDealerCards(dealer);
		System.out.println("****Dealer has " + dealerTotal(dealer));
		hit(dealer, player);
	}

	public static void showPlayerCards(Player player) {
		for (Card c : player.getHand().getCards()) {
			System.out.println("Player: " + c);
		}
	}

	public static void showDealerCards(Dealer dealer) {
		for (Card c : dealer.getHand().getCards()) {
			System.out.println("Dealer: " + c);
		}
	}

	public static int playerTotal(Player player) {
		int total = 0;
		for (Card c : player.getHand().getCards()) {
			System.out.println(c);
			total = total + c.getValue();
		}
		System.out.println("******* " + total + " *******");
		return total;
	}

	public static int dealerTotal(Dealer dealer) {
		int total = 0;
		for (Card c : dealer.getHand().getCards()) {
			System.out.println(c);
			total = total + c.getValue();
		}
		System.out.println("******* " + total + " *******");
		return total;
	}

	public static void hit(Dealer dealer, Player player) {
		String hitStay;
		boolean keepPlaying = true;
		while (keepPlaying) {
			System.out.println("Do you want to hit or stay?");
			hitStay = scanner.next();
			if (hitStay.equals("hit")) {
				player.getHand().add(dealer.deal());
				System.out.println("****************" + "\n");
				if (playerTotal(player) > 21) {
					System.out.println("You lose, You busted");
					keepPlaying = false;
				}

			} 
			
			
			else {

				while (dealerTotal(dealer) < 17) {
					dealer.getHand().add(dealer.deal());
					System.out.println("****************");
					if (dealerTotal(dealer) > 21) {
						System.out.println("Dealer Busted, you win!!");
						keepPlaying = false;
					}
				}
				keepPlaying = false;
			}

		}
		if (dealerTotal(dealer) < 21 && playerTotal(player) < 21) {

			checkForWin(dealer, player);
		}
	}

	public static void checkForWin(Dealer dealer, Player player) {
		if (dealerTotal(dealer) > playerTotal(player)) {
			System.out.println("You lose, dealer wins.");
		} else if (dealerTotal(dealer) < playerTotal(player)) {
			System.out.println("You win!!!");
		} else {
			System.out.println("You tied!");
		}
	}
}

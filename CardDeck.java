import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Card {
    private String rank;
    private String suit;
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

public class CardDeck {
    public static void main(String[] args) {

        List<Card> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a suit to find all the cards of that suit (Hearts, Spades, Diamonds, Clubs): ");
        String suitToFind = scanner.nextLine();

        System.out.println("\nCards of " + suitToFind + ":");
        boolean found = false;
        for (Card card : deck) {
            if (card.getSuit().equalsIgnoreCase(suitToFind)) {
                System.out.println(card);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cards found for the suit: " + suitToFind);
        }

        scanner.close();
    }
}

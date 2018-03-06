/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String ranks[] = {"jack", "queen", "king"};
		String suits[] = {"hearts", "spades"};
		int values[] = {11, 12, 13};
		Deck deck1 = new Deck(ranks, suits, values);
		Deck deck2 = new Deck(ranks, suits, values);
		Deck deck3 = new Deck(ranks, suits, values);
		System.out.println("Deck 1 Deal: " + deck1.deal() + " Deck 1 Size: " + deck1.size() + " Deck 1 isEmpty: " + deck1.isEmpty());
		System.out.println("Deck 2 Deal: " + deck2.deal() + " Deck 2 Size: " + deck2.size() + " Deck 2 isEmpty: " + deck2.isEmpty());
		System.out.println("Deck 3 Deal: " + deck3.deal() + " Deck 3 Size: " + deck3.size() + " Deck 3 isEmpty: " + deck3.isEmpty());
	}
}

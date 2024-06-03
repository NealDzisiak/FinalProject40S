/** Required package class namespace */
package finalproject40s;

/**
 * Deck.java - description
 *
 * @author Neal Dzisiak
 * @since May 8, 2024, 8:07:05 a.m.
 */
public class Deck {

    // the amount of suits for a deck of cards
    final int SUITNUMBER = 4;
    
    // the amount of different card values in a deck
    final int CARDNUMBER = 13;

    // the array for the deck
    public String[][] deck = new String[SUITNUMBER][CARDNUMBER];

    /**
     * Default constructor, set class properties
     */
    public Deck() {

        // creats a new deck each time the class is integrated
        NewDeck();

    }

    /**
     * 
     * shows the deck to the player
     * 
     */
    public void ShowDeck() {

        for (int row = 0; row < SUITNUMBER; row++) {
            for (int column = 0; column < CARDNUMBER; column++) {
                System.out.println(deck[row][column]);
            }
        }
        System.out.println("\n\n\n");
    }

    /**
     * 
     * Crests a new deck
     * 
     */
    private void NewDeck() {

        int s = 1;

        for (int row = 0; row < SUITNUMBER; row++) {
            String message1 = "suit " + s + " and ";
            s++;
            int n = 1;
            for (int column = 0; column < CARDNUMBER; column++) {
                String message2 = message1 + "card " + n;
                n++;
                deck[row][column] = message2;
            }
        }
    }

}

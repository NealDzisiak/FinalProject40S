/** Required package class namespace */
package finalproject40s;

/**
 * Deck.java - creates a deck for the player, and shows it
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
        newDeck();

    }

    /**
     *
     * shows the deck to the player
     *
     */
    public void showDeck() {

        // for every suit
        for (int row = 0; row < SUITNUMBER; row++) {
            
            // for every card
            for (int column = 0; column < CARDNUMBER; column++) {
                
                // output what is the array
                System.out.println(deck[row][column]);
                
            }
        }
        // for spacing
        System.out.println("\n\n\n");
    }

    /**
     *
     * Crests a new deck
     *
     */
    private void newDeck() {

        // the current suit number
        int s = 1;

        // for each suit
        for (int row = 0; row < SUITNUMBER; row++) {
            
            // make a message that says the suit number
            String message1 = "suit " + s + " and ";
            
            // increase the suit number
            s++;
            
            // the curent card value
            int n = 1;
            
            // for each card
            for (int column = 0; column < CARDNUMBER; column++) {
                
                // take the first message and add on the cards value
                String message2 = message1 + "card " + n;
                
                // increase the cards value
                n++;
                
                // make that spot in the matrix the full message
                deck[row][column] = message2;
            }
        }
    }

}

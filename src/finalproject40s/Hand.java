/** Required package class namespace */
package finalproject40s;

import javax.swing.JOptionPane;

/**
 * Hand.java - the subclass of deck, is the hand
 *
 * @author Neal Dzisiak
 * @since May 6, 2024, 8:27:50 a.m.
 */
public class Hand extends Deck {

    /**
     * Default constructor, set class properties
     */
    public Hand() {

    }

    /**
     *
     * draws a new card
     * 
     * @param deck the array that contains the deck
     * @return the card drawn
     */
    public int NewCard(String[][] deck) {

        // the minimum valus
        final int MIN = 0;
        
        // the maximum value
        final int MAXNUMBER = 12;

        // a random number from the random method, number is between 
        int number = random(MIN, MAXNUMBER);

        final int MAXSUIT = 3;

        int suit = random(MIN, MAXSUIT);

        if ("x".equals(deck[suit][number])) {

            return NewCard(deck);

        } else {

            deck[suit][number] = "x";

            int value = cardCorrector(number);

            return value;

        }
    }

    /**
     * Generates a random number in a range between two numbers
     *
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number less than or equal to low and less than or equal to
     * the high number
     */
    private int random(int low, int high) {
        double seed = Math.random();
        double L = (double) low;
        double H = (double) high;
        double number = (H - L + 1) * seed + L;
        return (int) number;
    }

    
    /**
     * 
     * corrects the card value for blackjack
     * 
     * @param cardValue the cards value
     * @return the corrected card values
     */
    public int cardCorrector(int cardValue) {

        //if the card value is above or equal to 10
        if (cardValue >= 10) {

            // return 10
            return 10;

        }

        // otherwise return the value pluse one
        return cardValue + 1;

    }

}

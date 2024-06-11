/** Required package class namespace */
package finalproject40s;

/**
 * Hand.java - the subclass of deck, is the hand
 *
 * @author Neal Dzisiak
 * @since May 6, 2024, 8:27:50 a.m.
 */
public class Hand extends Deck {

    /**
     *
     * draws a new card
     *
     * @param deck the array that contains the deck
     * @return the card drawn
     */
    public int newCard(String[][] deck) {

        // the minimum valus
        final int MIN = 0;

        // the maximum card value
        final int MAXNUMBER = 12;

        // a random card value from the random method 
        int number = random(MIN, MAXNUMBER);

        // the maximum number of suits
        final int MAXSUIT = 3;

        // get a random suit
        int suit = random(MIN, MAXSUIT);

        // if the card has already been drawn
        if ("x".equals(deck[suit][number])) {

            // RECURSIVE CASE
            // rerun this method
            return newCard(deck);

            // otherwise
        } else {

            // BASE CASE
            // replace the card name with x. showing its drawn
            deck[suit][number] = "x";

            // correct the cards value for blackjack with the method 
            // card corrector 
            int value = cardCorrector(number);

            // return the value
            return value;

        }
    }

    /**
     *
     * Generates a random number in a range between two numbers
     *
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number less than or equal to low and less than or equal to
     * the high number
     */
    private int random(int low, int high) {

        // this generates a random decimal number between 0 and 1
        double seed = Math.random();

        // change the lowest number in the range to a double
        double L = (double) low;

        // change the highest number in the range to a double
        double H = (double) high;

        // use this equation to get a random double between the high and low
        // value
        double number = (H - L + 1) * seed + L;

        // return the number as a int
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

/** Required package class namespace */
package finalproject40s;
 
/**
 * Deck.java - description
 *
 * @author Neal Dzisiak
 * @since May 8, 2024, 8:07:05 a.m.
 */
public class Deck 
{

    final int SUITNUMBER = 4;
    final int CARDNUMBER = 13;
        
    protected String[][] deck = new String[SUITNUMBER][CARDNUMBER];
    
    /**
     * Default constructor, set class properties
     */
    public Deck() {
        
       NewDeck();
        
    }

    /**
     * Generates a random number in a range between two numbers
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number less than or equal to low and less than or
     * equal to the high number
     */
    private int random(int low, int high) {
        double seed   = Math.random();
        double L      = (double)low;
        double H      = (double)high;
        double number = (H - L + 1) * seed + L; 
        return (int)number;
    }
    
    /**
     *
     * @param deck
     * @return
     */
    public int NewCard() {
          
        final int MIN = 0;
        final int MAXNUMBER = 12;
            
        int number = random(MIN,MAXNUMBER); //random between 0 and 1 (not 0 or 1)
        
        final int MAXSUIT = 3;
            
        int suit = random(MIN,MAXSUIT); //random between 0 and 1 (not 0 or 1)
            
        if ("x".equals(deck[suit][number])){
            
            return NewCard();
            
        }
        else
        {
        
            deck[suit][number] = "x";
        
            return number;
        
        }
    }

    public void ShowDeck() {
        
        for (int row = 0; row < SUITNUMBER; row++) {
            for (int column = 0; column < CARDNUMBER; column++) {
                System.out.println(deck[row][column]);
            }
        }
        System.out.println("\n\n\n");
    }

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
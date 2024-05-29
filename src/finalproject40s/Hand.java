/** Required package class namespace */
package finalproject40s;
 
import javax.swing.JOptionPane;

/**
 * Hand.java - description
 *
 * @author Neal Dzisiak
 * @since May 6, 2024, 8:27:50 a.m.
 */
public class Hand extends Deck
{
    
    /**
     * Default constructor, set class properties
     */
    public Hand() {
        
        
        
    }
     
    /**
     *
     * @param deck
     * @return
     */
    public int NewCard(String[][] deck) {
          
        final int MIN = 0;
        final int MAXNUMBER = 12;
            
        int number = random(MIN,MAXNUMBER); 
        
        final int MAXSUIT = 3;
            
        int suit = random(MIN,MAXSUIT); 
            
        if ("x".equals(deck[suit][number])){
            
            return NewCard(deck);
            
        }
        else
        {
            
            deck[suit][number] = "x";
        
            return number;
        
        }
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
       

}
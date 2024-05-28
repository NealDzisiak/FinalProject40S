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

    String total = "You have ";
    
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
            
        int number = random(MIN,MAXNUMBER); //random between 0 and 1 (not 0 or 1)
        
        final int MAXSUIT = 3;
            
        int suit = random(MIN,MAXSUIT); //random between 0 and 1 (not 0 or 1)
            
        if ("x".equals(deck[suit][number])){
            
            return NewCard(deck);
            
        }
        else
        {
        
            total = total + deck[suit][number] + ", ";
            
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
       
    
    public void showHand(){        
        
        // welcoms them to the program
        JOptionPane.showMessageDialog(
                null, 
                total,
                "hand test",
                JOptionPane.PLAIN_MESSAGE
        );
        
        
    }
    
    
    
    
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Hand clone() {
        return this;
    }
    
}
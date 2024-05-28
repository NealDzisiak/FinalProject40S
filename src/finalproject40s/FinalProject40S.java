package finalproject40s;

import javax.swing.JOptionPane;


/*
 * FinalProject40S - description
 * 
 * @author Neal Dzisiak
 * @since Apr 19, 2024
*/
public class FinalProject40S
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final String TITLE = "Blackjack";
        
        
        int cash = 200;
        
        start(TITLE);
        
        program(TITLE,cash);
        
    }

    /**
     * 
     * welcomes them to the program then sends them to the program
     * 
     * @param title the title of the program
     */
    private static void start(String TITLE) {
        
        // welcoms them to the program
        JOptionPane.showMessageDialog(
                null, 
                "Welcome to " + TITLE,
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );
        
    }
    
    private static int makeBet(String TITLE, int cash) {
        // let them enter a number for the base in the form of a string        
        String number = JOptionPane.showInputDialog(
                null,
                "You have " + cash + " dollars,\n how much do you want to bet?",
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );
        
        boolean isLetter = isAlpha(number);
                
        if (isLetter == true){
            
            // welcoms them to the program
            JOptionPane.showMessageDialog(
                null, 
                """
                You can't bet letters, please try again""",
                TITLE,
                JOptionPane.PLAIN_MESSAGE
            );
            
            return makeBet(TITLE,cash);
            
        }
        else {
           
            // then change the string into an int
            int bet = Integer.parseInt(number);
        
            if (bet > cash){
            
            // welcoms them to the program
                JOptionPane.showMessageDialog(
                    null, 
                    """
                    You don't have that much money,
                    please make a smaller bet""",
                    TITLE,
                    JOptionPane.PLAIN_MESSAGE
                );
            
                return makeBet(TITLE,cash);
            
            }
            else if(bet < 0){
            
                // welcoms them to the program
                JOptionPane.showMessageDialog(
                    null, 
                    """
                    You can't bet negative money,
                    please make a actual bet""",
                    TITLE,
                    JOptionPane.PLAIN_MESSAGE
                );

                return makeBet(TITLE,cash);

            }
            else{

                return bet;

            }
            
        }
        
        
        
    }    

    /**
     * 
     * checks to see if the string has any letters in it
     * 
     * @param name the entered string
     * @return weather or not the string contains any letters
     */
    public static boolean isAlpha(String name) {
        
    return name.matches("[a-zA-Z]+");
    
    }


    private static void program(String TITLE, int cash) {
        
        if(cash == 0){
            
            // welcoms them to the program
            JOptionPane.showMessageDialog(
                null, 
                "You are out of cash",
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );
            
            end(TITLE);
            
        }
        
        int bet = makeBet(TITLE, cash);
        
        cash = cash - bet; 
            
        Deck card = new Deck();
        
        Hand hand = new Hand();
        
        hand.NewCard();
        
        DrawCard(TITLE);
        
        
        
        
        
        
        
        card.ShowDeck();
        
        hand.showHand();
        
        
        playAgain(TITLE,cash);
        
        
        
        
    }

    /**
     * 
     * give them the option to do it again or exit the program
     * 
     * @param title the title of the program
     */
    private static void playAgain(String TITLE, int cash) {
        
        // creats a message box that showes them the options yes and no and puts
        // it into a integer (Because i cant figure out how to do it any other 
        // way)
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Do you want to play again?",
                TITLE,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        // if they chose yes, then...
        if (choice == JOptionPane.YES_OPTION){
            
            // this sends them back to the start
            program(TITLE,cash);
                      
        }
        else{
            
        // end of the program
        end(TITLE);
            
        }
          
    }

     /**
     * 
     * Says goodbye and ends the program
     * 
     * @param title the title of the program
     */
    private static void end(String title) {
    
        // thank them for using the program
        JOptionPane.showMessageDialog(
                null, 
                "Thanks for using " + title,
                title,
                JOptionPane.PLAIN_MESSAGE
        );
        
        // Ends the program
        System.exit(0);
    }

    private static void DrawCard(String TITLE) {
        
        int choice = JOptionPane.showConfirmDialog(
            null,
            "Do you want to draw a card?",
            TITLE,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        while(choice == JOptionPane.YES_OPTION){
            
//            hand.NewCard();
            
            
        }
    }

    
}
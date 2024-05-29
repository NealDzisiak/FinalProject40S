/** Required package class namespace */
package finalproject40s;
 
import javax.swing.JOptionPane;

/**
 * GameController.java - description
 *
 * @author Neal Dzisiak
 * @since May 29, 2024, 2:19:34 p.m.
 */
public class GameController implements Blackjack, Game
{
    
    public GameController() {
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
    private void start(String TITLE) {
        
        // welcoms them to the program
        JOptionPane.showMessageDialog(
                null, 
                "Welcome to " + TITLE,
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );
        
    }
    
    @Override
    public int makeBet(String TITLE, int cash) {
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
    public boolean isAlpha(String name) {
        
        return name.matches("[a-zA-Z]+");
    
    }


    private void program(String TITLE, int cash) {
        
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
         
            
        Deck deck = new Deck();
        Hand hand = new Hand();
        
        int dealerCard1 = hand.NewCard(deck.deck);
        int dealerCard2 = hand.NewCard(deck.deck);
        int dealerCard3 = hand.NewCard(deck.deck);
        
        int dealerHandTotal = dealerCard1 + dealerCard2 + dealerCard3;
        
        int card1 = hand.NewCard(deck.deck);
        int card2 = hand.NewCard(deck.deck);
        
        int handTotal = card1 + card2;
        
        
        String choice = JOptionPane.showInputDialog(
                null,
                "You have a " + card1 + " and " + card2 
                + " for a total of " + handTotal 
                + "\nWould you like to Hit(h) or Stand(s)",
                TITLE,
                JOptionPane.QUESTION_MESSAGE
        );
        while (choice.equalsIgnoreCase("H") == false &&
                choice.equalsIgnoreCase("S") == false) {
            
            choice = JOptionPane.showInputDialog(
                    null,
                    "You have a " + card1 + " and " + card2 
                    + " for a total of " + handTotal 
                    + "\nWould you like to Hit(h) or Stand(s)",
                    TITLE,
                    JOptionPane.QUESTION_MESSAGE
                    
            );
        }
        if (choice.equalsIgnoreCase("H")){
            
            int card3 = hand.NewCard(deck.deck);

            handTotal = handTotal + card3;
            
            
        }
 
        boolean whoWins = WinCon(handTotal,dealerHandTotal);
        
        if(whoWins == true){
            
            cash = Win(cash,bet);
            
        }
        else if(whoWins == false){
            
            cash = lost(cash,bet);
            
        }
        
        deck.ShowDeck();

        playAgain(TITLE,cash);

        
        
    }

    /**
     * 
     * give them the option to do it again or exit the program
     * 
     * @param title the title of the program
     */
    private void playAgain(String TITLE, int cash) {
        
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
    private void end(String title) {
    
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

    @Override
    public boolean WinCon(int handTotal, int dealerHand) {
        
        if (handTotal > 21){
            
            return false;
            
        }
        else if (handTotal > dealerHand){
            
            return true;
            
        }
        
        return false;
    }

    @Override
    public int Win(int cash, int bet) {
        
        JOptionPane.showMessageDialog(null, "You Win!");
        
        int reward = bet;
        
        int money = cash + reward;
        
        return money;
        
    }

    @Override
    public int lost(int cash, int bet) {
        JOptionPane.showMessageDialog(null, "You lost");
        
        int owed = bet;
        
        int money = cash - owed;
        
        return money;
    }

}
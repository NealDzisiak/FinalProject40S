/** Required package class namespace */
package finalproject40s;

import javax.swing.JOptionPane;

/**
 * GameController.java - description
 *
 * @author Neal Dzisiak
 * @since May 29, 2024, 2:19:34 p.m.
 */
public class GameController implements Blackjack, Game {

    public GameController() {
        
        // variable containing title of the program
        final String TITLE = "Blackjack";

        // variable containing the players cash
        int cash = 200;

        // calls the start method
        start(TITLE);

        // calls the program method
        program(TITLE, cash);
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

    /**
     *
     * allows the player to make a bet
     *
     * @param TITLE the title of the program
     * @param cash the players cash
     * @return the bet the player made
     */
    @Override
    public int makeBet(String TITLE, int cash) {
        
        // let them enter a number for the base in the form of a string        
        String number = JOptionPane.showInputDialog(
                null,
                "You have " + cash + " dollars,\n how much do you want to bet?",
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );

        // checks to see if the entered string contains only numbers
        boolean isNumber = isAlpha(number);

        // if it dosn't...
        if (isNumber == false) {

            // tell them that they cant only enter numbers
            JOptionPane.showMessageDialog(
                    null,
                    """
                You can't enter letters or charecters, please try again""",
                    TITLE,
                    JOptionPane.PLAIN_MESSAGE
            );

            // rerun the method
            return makeBet(TITLE, cash);

        } else {

            // then change the string into an int
            int bet = Integer.parseInt(number);

            // if the bet is larger then the players cash...
            if (bet > cash) {

                // tell them they bet more then they have
                JOptionPane.showMessageDialog(
                        null,
                        """
                    You don't have that much money,
                    please make a smaller bet""",
                        TITLE,
                        JOptionPane.PLAIN_MESSAGE
                );

                // rerun the method
                return makeBet(TITLE, cash);

                // otherwise
            } else {

                // return the bet
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

        // looks to see if the string only contains a number
        return name.matches("[0-9]+");

    }

    /**
     *
     * the program that simulates a game of blackjack
     *
     * @param TITLE the programs title
     * @param cash the player cash
     */
    private void program(String TITLE, int cash) {

        // the players bet is created in the makebet  method and sent here
        int bet = makeBet(TITLE, cash);

        // create a new deck
        Deck deck = new Deck();
        
        // create a new hand
        Hand hand = new Hand();

        // draw 3 cards for the dealer
        int dealerCard1 = hand.NewCard(deck.deck);
        int dealerCard2 = hand.NewCard(deck.deck);
        int dealerCard3 = hand.NewCard(deck.deck);

        // add the values together for a total
        int dealerHandTotal = dealerCard1 + dealerCard2 + dealerCard3;

        // draw 2 cards for the player
        int card1 = hand.NewCard(deck.deck);
        int card2 = hand.NewCard(deck.deck);

        // add the values together for a total
        int handTotal = card1 + card2;

        // creats a message containing the individual values of the cards in 
        // the players hand
        String message1 = "You have a " + card1 + " and " + card2;
        
        // innitializes choics
        String choice = "";

        // while the players choice dosn't equal H or S (capitalization dosn't 
        // matter) repeat this part of the program
        while (choice.equalsIgnoreCase("H") == false
                && choice.equalsIgnoreCase("S") == false) {

            // give the player a choice to hit or stand
            choice = Options(TITLE, message1, handTotal);

            // while the choice is hit
            while (choice.equalsIgnoreCase("H")) {

                // draw a new card for the player
                int drawnCard = hand.NewCard(deck.deck);

                // add it to the hand total
                handTotal = handTotal + drawnCard;

                // update the message so it also has the new cards value
                message1 = message1 + " and " + drawnCard;

                // if the hand total is now above 21
                if (handTotal > 21) {

                    // show them they bustedthey bust
                    JOptionPane.showMessageDialog(
                            null,
                            "You busted with " + message1
                    );

                    // change choice to s
                    choice = "s";

                    // if its not greater then 21
                } else {

                    // give them the option to hit or stand again
                    choice = Options(TITLE, message1, handTotal);

                }
            }
        }

        // thanks to clasic casino rules, the dealer must hit if under 17, so
        // while the dealers total hand value is below 17
        while (dealerHandTotal < 17) {

            // draw the dealer a new card
            int newDealerCard = hand.NewCard(deck.deck);

            // add the new cards value to the dealers total hand value
            dealerHandTotal = dealerHandTotal + newDealerCard;

        }

        // checks to see if the player won
        boolean whoWins = WinCon(handTotal, dealerHandTotal);
        
        // if the player won
        if (whoWins == true) {

            // get the player new money from the win method
            cash = Win(cash, bet, handTotal,
                    dealerHandTotal);

          // if the player lost
        } else if (whoWins == false) {

            // get the player new money from the lose method
            cash = lose(cash, bet, handTotal, 
                    dealerHandTotal);
            
        }

        // error checking code that showes the deck
        deck.ShowDeck();
        
        // if the player is out of cash
        if (cash == 0) {

            // tell them they are out of cash
            JOptionPane.showMessageDialog(
                    null,
                    "You are out of cash",
                    TITLE,
                    JOptionPane.PLAIN_MESSAGE
            );

            // end the program
            end(TITLE);

        // else
        }else{
            
            // give them the option to end the program or replay it
            playAgain(TITLE, cash);

        }
        
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
        if (choice == JOptionPane.YES_OPTION) {

            // this sends them back to the start
            program(TITLE, cash);

        } else {

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

    /**
     *
     * the win conditions of the game
     * 
     * @param playerHand the players hand total
     * @param dealerHand the dealers hand total
     * @return if the player won
     */
    @Override
    public boolean WinCon(int playerHand, int dealerHand) {

        // if the players hand is above 21
        if (playerHand > 21) {

            // you lose
            return false;

            // else if the dealers hand is above 21
        } else if (dealerHand > 21) {

            // you win
            return true;

            // else if the players hand is greater then the dealers hand
        } else if (playerHand > dealerHand) {

            // you win
            return true;

        }

        // if nothing else is triggered, you lose
        return false;
    }

    /**
     *
     * if the player wins
     *
     * @param cash the players cash
     * @param reward the players reward
     * @param playerHand the players hand total
     * @param dealerHand the dealers hand total
     * @return the players new amount of money
     */
    @Override
    public int Win(int cash, int reward, int playerHand, int dealerHand) {

        // show the, that they won, and the players and dealers hand
        JOptionPane.showMessageDialog(
                null,
                "You Win!\nWith " + playerHand
                + ", the dealer had " + dealerHand);

        // new amount of money equals the old amount, pluse the amount owed
        int money = cash + reward;

        // return the new amount of money
        return money;

    }

    /**
     *
     * if the player loses
     *
     * @param cash the players cash
     * @param owed the players money owed
     * @param playerHand the players hand total
     * @param dealerHand the dealers hand total
     * @return the players new amount of money
     */
    @Override
    public int lose(int cash, int owed, int playerHand, int dealerHand) {
        
        // show the, that they lost, and the players and dealers hand
        JOptionPane.showMessageDialog(
                null,
                "You lost\nWith " + playerHand
                + ", the dealer had " + dealerHand);

        // new amount of money equals the old amount, minus the amount owed
        int money = cash - owed;

        // return the new amount of money
        return money;
    }

    /**
     *
     * allows the player to make a choice
     *
     * @param TITLE the programs title
     * @param message1 first part of the message
     * @param message2 second part of the message
     * @return the players choice
     */
    private String Options(String TITLE, String message1, int handTotal) {
        
        // showes the player the choice to hit or stand
        String choice = JOptionPane.showInputDialog(
                null,
                message1 + "\nfor a total of " + handTotal
                        + "\nWould you like to Hit(h) or Stand(s)",
                TITLE,
                JOptionPane.QUESTION_MESSAGE
        );

        // returns the players choice
        return choice;

    }

}

package finalproject40s;

/**
 *
 * the rules specific to blackjack
 * 
 * @author n.dzisiak
 */
public interface Blackjack extends Game {

    boolean winCon(int handTotal, int dealerHand, int blackjack);

}

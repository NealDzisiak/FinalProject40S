package finalproject40s;

/**
 *
 * the rules for all the games
 * 
 * @author n.dzisiak
 */
public interface Game {

    int makeBet(String TITLE, int cash);

    int Win(int cash, int bet, int handTotal, int dealerHandTotal);

    int lost(int cash, int bet, int handTotal, int dealerHandTotal);

}

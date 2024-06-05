package finalproject40s;

/**
 *
 * the rules for all the games
 * 
 * @author n.dzisiak
 */
public interface Game {

    int makeBet(int cash);

    int win(int cash, int bet, int handTotal, int dealerHandTotal);

    int lose(int cash, int bet, int handTotal, int dealerHandTotal);

}

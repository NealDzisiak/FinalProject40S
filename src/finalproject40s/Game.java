/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package finalproject40s;

/**
 *
 * @author n.dzisiak
 */
public interface Game {
    
    void HandSize(int number ); 
    int NewCard(String[][] deck);
    boolean Win (int handTotal, int dealerHand);
    
}

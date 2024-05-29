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

    int makeBet(String TITLE, int cash);
    
    int Win (int cash, int bet);
    
    int lost (int cash, int bet);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2minesweeper;

/**
 *
 * @author Nicolle
 */
public class Game {
    private Board board;
    boolean finish = false;
    boolean win = false;
    int turn=0;
    
    public Game(){
        board = new Board();
        Play(board);
    }
    
    public void Play(Board board){
        do{
            turn++;
            System.out.println("Turn "+turn);
            board.show();
            finish = board.setPosition();
            
            if(!finish){
                board.openNeighbors();
                finish = board.win();
            }
            
        }while(!finish);
        
        if(board.win()){
            System.out.println("Congratulations, you let the 10 fields with the mines in "+turn+" turns");
            board.showMines();
        } else {
            System.out.println("Mine! You lost!");
            board.showMines();
        }
    }

}

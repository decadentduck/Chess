/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.util.Scanner;

public class Chess 
{
    public static void main(String[] args) 
    {
        //initialize
        boolean running = true;
        ChessBoard game = new ChessBoard();
        game.Setup();
        String player = "white";
        Scanner sc = new Scanner(System.in);
        
        //game loop
        while(running)
        {
            //update
            if(game.gameOver()) running = false;
            //render
            game.Draw();
            //handle events
            if(game.turn(player, sc.next("[A-Z]").charAt(0), sc.nextInt(), sc.next("[A-Z]").charAt(0), sc.nextInt()))
            {
                if(player.equals("white")) player = "black";
                else player = "white";
            }
        }
    }
}

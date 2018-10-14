/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.util.InputMismatchException;
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
            //draw board
            game.Draw();
            //player turn
            try
            {
                if(game.turn(player, sc.next("[A-Z]").charAt(0), sc.nextInt() -1, sc.next("[A-Z]").charAt(0), sc.nextInt()-1))
                {
                    if(player.equals("white")) player = "black";
                    else player = "white";
                }
            if(game.gameOver()) running = false;
            }
            catch(InputMismatchException ex)
            {
                System.out.println(ex.getMessage());
            }
            //check win
            if(game.gameOver()) running = false;
        }
    }
}

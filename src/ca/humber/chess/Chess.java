/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Chess 
{
    public static void main(String[] args) 
    {
        //initialize
        boolean running = true;
        ChessBoard game = new ChessBoard();
        game.Setup();
        String player = "white";
        
        //game loop
        while(running)
        {
            //update
            //render
            game.Draw();
            //handle events
            running = false;
        }
    }
}

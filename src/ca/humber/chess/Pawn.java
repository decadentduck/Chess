/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Pawn extends ChessPiece
{
    boolean firstMove;
    public Pawn(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'P';
        else symbol = 'p';
        firstMove = true;
    }
    
    @Override
    public Boolean CheckMove(int r1, int c1, int r2, int c2, ChessPiece[][] board)
    {
        //need to check board to see if any piece is in the way
        //need to implement diagocal if enemy occupies the space
        
        //stay in same column
        if( c1 == c2)
        {
           int difference = r2 - r1;
           int d = difference;
           if(d < 0) d *= -1;
            //if first turn move 1 or 2
            if(firstMove)
            {
                if (d > 2) return false;
            }
            else
            {
                if (d > 1) return false;
            }
            //if its white can move up 
            if(colour.equals("white"))
            {
                if (difference <= 0) return false;
            }
            else //if its black moves down
            {
                if (difference >= 0) return false;
            }
        }
        else return false;
        
        return true;
    }
}

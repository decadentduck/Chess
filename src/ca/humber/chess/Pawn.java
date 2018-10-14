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
    public Boolean CheckMove(int r1, int c1, int r2, int c2)
    {
        if (colour.equals("white")) 
        {
            if (firstMove)
            {
                //apparently a pawn can move two spaces forwards, but only the first time it moves
                if (c1 != c2 || r2 - r1 > 2) return false;
                else firstMove = false;
            }
            //else can move one space forward
            else if (c1 != c2 || r2 - r1 != 1) return false;
        } 
        else 
        {
            if (firstMove)
            {
                //apparently a pawn can move two spaces forwards, but only the first time it moves
                if (c1 != c2 || r1 - r2 > 2) return false;
                else firstMove = false;
            }
            //else can move one space forward
            else if (c1 != c2 || r1 - r2 != 1) return false;
        }
        
        return true;
    }
}

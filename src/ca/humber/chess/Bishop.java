/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Bishop extends ChessPiece
{
    public Bishop(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'B';
        else symbol = 'b';
    }
    
    @Override
    public Boolean CheckMove(int x1_, int y1_, int x2_, int y2_)
    {
        //diagonals if no piece in the way
        return true;
    }
}
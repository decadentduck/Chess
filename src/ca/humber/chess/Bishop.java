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
    public Boolean CheckMove(int r1, int c1, int r2, int c2, ChessPiece[][] board)
    {
        //diagonals if no piece in the way
        return true;
    }
}
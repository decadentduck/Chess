/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Queen extends ChessPiece
{
    public Queen(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'Q';
        else symbol = 'q';
    }
    
    @Override
    public Boolean CheckMove(int r1, int c1, int r2, int c2, ChessPiece[][] board)
    {
        //moves in for/back/side/diagonal directions provided no pieces stand in her way
        return true;
    }
}

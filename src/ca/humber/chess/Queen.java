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
    public Boolean CheckMove(int x1_, int y1_, int x2_, int y2_)
    {
        return true;
    }
}

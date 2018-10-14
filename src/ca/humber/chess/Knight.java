/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Knight extends ChessPiece
{
    public Knight(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'K';
        else symbol = 'k';
    }
    
    @Override
    public Boolean CheckMove(int x1_, int y1_, int x2_, int y2_)
    {
        return true;
    }
}
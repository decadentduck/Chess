/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class King extends ChessPiece
{
    public King(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'X';
        else symbol = 'x';
        
    }
    
    @Override
    public Boolean CheckMove(int x1_, int y1_, int x2_, int y2_)
    {
        return true;
    }
}

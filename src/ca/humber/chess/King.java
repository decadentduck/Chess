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
    public Boolean CheckMove(char c1_, int y1_, char c2_, int y2_)
    {
        int x1 = c1_;
        int x2 = c2_;
        return true;
    }
}

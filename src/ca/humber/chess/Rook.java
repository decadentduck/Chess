/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Rook extends ChessPiece
{
    public Rook(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'R';
        else symbol = 'r';
    }
    
    @Override
    public Boolean CheckMove(int x1_, int y1_, int x2_, int y2_)
    {
        
        if (x1 != x2 && y1 != y2){ return false;}
            
        return true;
    }
}
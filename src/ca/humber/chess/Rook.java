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
    public Boolean CheckMove(int x1, int y1, int x2, int y2)
    {
        
        if (x1 != x2 && y1 != y2){ return false;}
            
        return true;
    }
}
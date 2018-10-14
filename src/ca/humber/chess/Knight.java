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
        if (x2_ != x1_ + 2 || x2_ != x1_ - 2 || x2_ != x1_ + 1 || x2_ != x1_ - 1)
        {
            if(y2_ != y1_ + 2 || y2_ != y1_ - 2 || y2_ != y1_ + 1 || y2_ != y1_ - 1)
            {
                if(y2_ == y1_ + 2 && x2_ == x1_ + 2 || y2_ == y1_ + 2 && x2_ == x1_ - 2 || y2_ == y1_ - 2 && x2_ == x1_ + 2 || y2_ == y1_ - 2 && x2_ == x1_ - 2 )
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
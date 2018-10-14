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
    public Boolean CheckMove(int r1, int c1, int r2, int c2)
    {
        if (r2 != r1 + 2 || r2 != r1 - 2 || r2 != r1 + 1 || r2 != r1 - 1)
        {
            if(c2 != c1 + 2 || c2 != c1 - 2 || c2 != c1 + 1 || c2 != c1 - 1)
            {
                if(c2 == c1 + 2 && r2 == r1 + 2 || c2 == c1 + 2 && r2 == r1 - 2 || c2 == c1 - 2 && r2 == r1 + 2 || c2 == c1 - 2 && r2 == r1 - 2 )
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
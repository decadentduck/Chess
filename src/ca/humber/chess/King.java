
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
    public Boolean CheckMove(char x1, int y1, char x2, int y2)
    {
        return true;
    }
}

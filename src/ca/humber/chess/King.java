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
    public Boolean CheckMove(int r1, int c1, int r2, int c2, ChessPiece[][] board)
    {
        //one space in any diection
        int difr = r2 - r1;
        if (difr < 0) difr *= -1;
        
        int difc = r2 - r1;
        if (difc < 0) difr *= -1;
        
        if(difr > 1 || difc > 1) return false;
        
        return true;
    }
}

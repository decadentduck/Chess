/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class King extends ChessPiece
{
    public King(String colour_, int row, int column) 
    {
        r1 = row;
        c1 = column;
        colour = colour_;
        if(colour.equals("white")) symbol = 'X';
        else symbol = 'x';
        
    }
    
    public Boolean CanMoveTo(int r2, int c2, ChessPiece[][] board)
    {
        //one space in any diection
        int difr = r2 - r1;
        int difc = r2 - r1;
        
        if(Math.abs(difr) > 1 || Math.abs(difc) > 1) return false;
        
        return true;
    }
}

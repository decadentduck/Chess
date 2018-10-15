/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public abstract class ChessPiece 
{
    protected String colour;
    protected char symbol;
    protected int r1, c1;
    
    public abstract Boolean CanMoveTo(int r2, int c2, ChessPiece[][] board);
            
    public void MoveTo(int row, int column, ChessPiece[][] board)
    {
        if(CanMoveTo(row, column, board))
        {
            r1 = row;
            c1 = column;
        }
    }
}
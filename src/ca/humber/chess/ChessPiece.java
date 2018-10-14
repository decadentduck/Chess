package ca.humber.chess;

public abstract class ChessPiece 
{
    protected String colour;
    protected char symbol;
    
    public Boolean CheckMove(int row1, int col1, int row2, int col2)
    {
        return true;
    }
}
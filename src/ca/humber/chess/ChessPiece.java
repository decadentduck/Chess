package ca.humber.chess;

public abstract class ChessPiece 
{
    protected String colour;
    protected char symbol;
    
    public Boolean CheckMove(int r1, int c1, int r2, int c2)
    {
        return true;
    }
}
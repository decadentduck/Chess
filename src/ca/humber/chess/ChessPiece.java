package ca.humber.chess;

public abstract class ChessPiece 
{
    protected String colour;
    protected char symbol;
    int x1, x2, y1, y2;
    
    public Boolean CheckMove(char x1_, int y1_, char x2_, int y2_)
    {
        return true;
    }
}
package ca.humber.chess;

public abstract class ChessPiece 
{
    protected String colour;
    protected char symbol;
    
    public Boolean CheckMove(char x1, int y1, char x2, int y2)
    {
        return true;
    }
}
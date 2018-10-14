package ca.humber.chess;

public class Bishop extends ChessPiece
{
    public Bishop(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'B';
        else symbol = 'b';
    }
    
    @Override
    public Boolean CheckMove(char x1, int y1, char x2, int y2)
    {
        return true;
    }
}
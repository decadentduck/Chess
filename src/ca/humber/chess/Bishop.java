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
    public Boolean CheckMove(char x1_, int y1_, char x2_, int y2_)
    {

        return true;
    }
}
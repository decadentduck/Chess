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
    public Boolean CheckMove(char c1_, int y1_, char c2_, int y2_)
    {
        int x1 = c1_;
        int x2 = c2_;
        return true;
    }
}
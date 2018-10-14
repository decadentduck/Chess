/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Rook extends ChessPiece
{
    public Rook(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'R';
        else symbol = 'r';
    }
    
    @Override
    public Boolean CheckMove(int r1, int c1, int r2, int c2, ChessPiece[][] board)
    {
        //moves up down left right if no piece is in the way
        
        if (r1 == r2) //moving sideways
        {
            //if direction is right
            if(c2 - c1 > 0) 
            {
                for(int c = c1 + 1; c < c2; c++)
                {
                    if (board[r1][c] != null) return false;
                }
            } 
            else //direction is left
            {
                for(int c = c1 - 1; c > c2; c--)
                {
                    if (board[r1][c] != null) return false;
                }
            } 
        }
        else if(c1 == c2) //moving up/down
        {
            //if direction is up
            if(r2 - r1 > 0) 
            {
                for(int r = r1 + 1; r < r2; r++)
                {
                    if (board[r][c1] != null) return false;
                }
            } 
            else //direction is down
            {
                for(int r = r1 - 1; r > r2; r--)
                {
                    if (board[r][c1] != null) return false;
                }
            } 
            
            
        }
        else return false;
            
        return true;
    }
}
/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Pawn extends ChessPiece
{
    boolean firstMove;
    public Pawn(String colour_, int row, int column) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'P';
        else symbol = 'p';
        firstMove = true;
    }
    
    public Boolean CanMoveTo(int r2, int c2, ChessPiece[][] board)
    {
        int differenceR = r2 - r1;
        int differenceC = c2 - c1;
        
        //stay in same column
        if( c1 == c2)
        {
           
            //if first turn move 1 or 2
            if(firstMove)//if first turn move 1 or 2
            {
                if (Math.abs(differenceR) > 2) return false;
            }
            //otherwise can only move 1 space
            else if (Math.abs(differenceR) > 1) return false;
            
            
            //check if enemy piece is in the way
            if(board[r2][c2] != null) return false; 
            
            if (!checkDirection(differenceR)) return false;
        }
        //else if enemy piece is diagonally in front of the pawn
        else if (Math.abs(differenceR) == 1 && Math.abs(differenceC) == 1) //diagonal move requested
        {
            if(board[r2][c2] != null && !board[r2][c2].colour.equals(colour))//if enemy piece is there
            {
                if (!checkDirection(differenceR)) return false;
            }
            else return false; //enemy piece not there
        }
        else return false;//if not in same column return false
        
        firstMove = false;
        return true;
    }
    
    public boolean checkDirection(int differenceR)
    {
        //if its white can move up 
                if(colour.equals("white") && differenceR < 0) return false;
                //if its black moves down
                else if (colour.equals("black") && differenceR > 0) return false;
        return true;
    }
}

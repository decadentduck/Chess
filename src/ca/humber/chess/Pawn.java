/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Pawn extends ChessPiece
{
    boolean firstMove;
    public Pawn(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'P';
        else symbol = 'p';
        firstMove = true;
    }
    
    @Override
    public Boolean CheckMove(int r1, int c1, int r2, int c2, ChessPiece[][] board)
    {
//        //need to check board to see if any piece is in the way
//        //need to implement diagocal if enemy occupies the space
//        
//        //stay in same column
//        if( c1 == c2)
//        {
//           int difference = r2 - r1;
//           int d = difference;
//           if(d < 0) d *= -1;
//            //if first turn move 1 or 2
//            if(firstMove)//if first turn move 1 or 2
//            {
//                if (d > 2) return false;
//            }
//            else
//            {
//                if (d > 1) return false;
//            }
//            //if its white can move up 
//            if(colour.equals("white"))
//            {
//                if (difference <= 0) return false;
//            }
//            else //if its black moves down
//            {
//                if (difference >= 0) return false;
//            }
//        }
//        else return false;
//        
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

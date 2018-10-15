/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Bishop extends ChessPiece
{
    public Bishop(String colour_, int row, int column) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'B';
        else symbol = 'b';
    }
    
    public Boolean CanMoveTo(int r2, int c2, ChessPiece[][] board)
    {
        //diagonals if no piece in the way
        int distR = r2 - r1;
        int distC = c2 - c1;
        
        if (Math.abs(distR) != Math.abs(distC)){return false;}
        else {
            if (distR > 0){
                if (distC > 0){
                    for(int r = r1 + 1; r < r2; r++){
                        for(int c = c1 + 1; c < c2; c++){
                            if (board[r][c] != null) return false;
                        }
                    }
                }
                else {
                    for(int r = r1 + 1; r < r2; r++){
                        for(int c = c1 - 1; c > c2; c--){
                            if (board[r][c] != null) return false;
                        }
                    }
                }
            }
            else{
                if (distC > 0){
                    for(int r = r1 - 1; r > r2; r--){
                        for(int c = c1 + 1; c < c2; c++){
                            if (board[r][c] != null) return false;
                        }
                    }
                }
                else {
                    for(int r = r1 - 1; r > r2; r--){
                        for(int c = c1 - 1; c > c2; c--){
                            if (board[r][c] != null) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
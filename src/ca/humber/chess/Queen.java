/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Queen extends ChessPiece
{
    public Queen(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'Q';
        else symbol = 'q';
    }
    
    @Override
    public Boolean CheckMove(int r1, int c1, int r2, int c2, ChessPiece[][] board)
    {
        //moves in for/back/side/diagonal directions provided no pieces stand in her way
        //check if can move like a rook, if not check if can move like bishop
        
        Rook r = new Rook(colour);
        Bishop b = new Bishop(colour);
        
        if(r.CheckMove(r1, c1, r2, c2, board) || b.CheckMove(r1, c1, r2, c2, board)) return true;
        return false;
    }
}

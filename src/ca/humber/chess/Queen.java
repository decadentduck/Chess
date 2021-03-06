/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

public class Queen extends ChessPiece
{
    public Queen(String colour_, int row, int column) 
    {
        r1 = row;
        c1 = column;
        colour = colour_;
        if(colour.equals("white")) symbol = 'Q';
        else symbol = 'q';
    }
    
    public Boolean CanMoveTo(int r2, int c2, ChessPiece[][] board)
    {
        //moves in for/back/side/diagonal directions provided no pieces stand in her way
        //check if can move like a rook, if not check if can move like bishop
        
        Rook r = new Rook(colour, r1, c1);
        Bishop b = new Bishop(colour, r1, c1);
        
        if(r.CanMoveTo(r2, c2, board) || b.CanMoveTo(r2, c2, board)) return true;
        return false;
    }
}

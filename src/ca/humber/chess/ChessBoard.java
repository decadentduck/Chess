/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.humber.chess;

/**
 *
 * @author kaitl
 */
public class ChessBoard 
{
    ChessPiece[][] board;
    
    public ChessBoard()
    {
        board = new ChessPiece[8][8];
    }
    
    public void Setup()
    {
        //set everything to null
        for(int r = 0; r < board.length; r++)
        {
            for( int c = 0; c < board.length; c++)
            {
                board[r][c] = null;
            }
        }
        
        //pawns
        for(int i = 0; i < 8; i++)
        {
            board[1][i] = new Pawn("white");
        }
        for(int i = 0; i < 8; i++)
        {
            board[6][i] = new Pawn("black");
        }
        
        //rooks
        board[0][0] = new Rook("white");
        board[0][7] = new Rook("white");
        board[7][0] = new Rook("black");
        board[7][7] = new Rook("black");
        
        //knights
        board[0][2] = new Knight("white");
        
        //bishops
        
        //kings
        
        //queens
    }
    
    public void Draw()
    {
        for(int r = 8; r >= 0; r--)
        {
            for( int c = 0; c <= 8; c++)
            {
                System.out.print(" ");
                if(r < 8 && c < 8)
                {
                    if (board[r][c] != null) System.out.print(board[r][c].symbol);
                    else System.out.print(" ");
                }
                else 
                {
                    if (c < 8) System.out.print((char)(65 + c));
                    else if (r < 8) System.out.print(r + 1);
                }
            }
            System.out.print("\n");
        }
    }
}

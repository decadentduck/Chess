/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

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
        
        String a = "black";
        String b = "white";
          
        //pawns
        for(int i = 0; i < 8; i++)
        {
            board[1][i] = new Pawn(b);
        }
        for(int i = 0; i < 8; i++)
        {
            board[6][i] = new Pawn(a);
        }
        
        //rooks
        board[0][0] = new Rook(b);
        board[0][7] = new Rook(b);
        board[7][0] = new Rook(a);
        board[7][7] = new Rook(a);
        
        //knights
        board[0][1] = new Knight(b);
        board[0][6] = new Knight(b);
        board[7][1] = new Knight(a);
        board[7][6] = new Knight(a);
        
        //bishops
        board[0][2] = new Bishop(b);
        board[0][5] = new Bishop(b);
        board[7][2] = new Bishop(a);
        board[7][5] = new Bishop(a);
        
        //kings
        board[0][3] = new King(b);
        board[7][3] = new King(a);
        
        //queens
        board[0][4] = new Queen(b);
        board[7][4] = new Queen(a);
        
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
    
    public boolean turn(String player, char c1,int r1 , char c2, int r2) 
    {
        //convert chars
        int col1 = c1 - 65;
        int col2 = c2 - 65;
        System.out.print(r1);
        System.out.print(col1);
        System.out.println("");
        System.out.print(r2);
        System.out.println(col2);
        
        //check if there is a piece at that spot
        if(board[r1][col1] != null)
        {
            if(board[r1][col1].colour.equals(player))
            {
                System.out.println("player piece there");
                //check if that piece can move to specified spot
                if ((board[r2][col2] != null && !board[r2][col2].colour.equals(player)) || board[r2][col2] == null) 
                {
                    System.out.println("Legal move");
                    if (board[r1][col1].CheckMove(r1, col1, r2, col2)) 
                    {
                        System.out.println("did move");
                        board[r2][col2] = board[r1][col1];
                        board[r1][col1] = null;
                        return true;
                    }
                    else System.out.println("didnt move");
                }
                else System.out.println("Illegal move");
            }
            else System.out.println("piece there");
        }
        else System.out.println("null piece");
        
        return false;
    }
    
    public boolean gameOver()
    {
        //check if game is over
        int kings = 0;
        //set everything to null
        for(int r = 0; r < board.length; r++)
        {
            for( int c = 0; c < board.length; c++)
            {
                if(board[r][c] != null) 
                {
                    if(board[r][c].symbol == 'x' || board[r][c].symbol == 'X') kings++;
                }
            }
        }
        
        if (kings < 2) return true;
        return false;
    }
}

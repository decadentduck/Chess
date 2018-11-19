/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChessBoard extends JPanel
{
    ChessPiece[][] board;
    
    private JButton[] buttons;
    
    public ChessBoard()
    {
        board = new ChessPiece[8][8];
        Setup();
    }
    
    public ChessBoard(char[] sym)
    {
        board = new ChessPiece[8][8];
        int i = 0;
        for(int r = 0; r < board.length; r++)
        {
            for( int c = 0; c < board.length; c++)
            {
                switch(sym[i])
                {
                    case 'a':
                        board[r][c] = null;
                        break;
                    case 'p':
                        board[r][c] = new Pawn("black", r, c);
                        break;
                    case 'P':
                        board[r][c] = new Pawn("white", r, c);
                        break;
                    case 'r':
                        board[r][c] = new Rook("black", r, c);
                        break;
                    case 'R':
                        board[r][c] = new Rook("white", r, c);
                        break;
                    case 'b':
                        board[r][c] = new Bishop("black", r, c);
                        break;
                    case 'B':
                        board[r][c] = new Bishop("white", r, c);
                        break;
                    case 'k':
                        board[r][c] = new Knight("black", r, c);
                        break;
                    case 'K':
                        board[r][c] = new Knight("white", r, c);
                        break;
                    case 'x':
                        board[r][c] = new King("black", r, c);
                        break;
                    case 'X':
                        board[r][c] = new King("white", r, c);
                        break;
                    case 'q':
                        board[r][c] = new Queen("black", r, c);
                        break;
                    case 'Q':
                        board[r][c] = new Queen("white", r, c);
                        break;
                    default:
                        break;
                }
                i++;
            }
        }
    }
    
    private void Setup()
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
            board[1][i] = new Pawn(b, 1, i);
        }
        for(int i = 0; i < 8; i++)
        {
            board[6][i] = new Pawn(a, 6, i);
        }
        
        //rooks
        board[0][0] = new Rook(b, 0, 0);
        board[0][7] = new Rook(b, 0, 7);
        board[7][0] = new Rook(a, 7, 0);
        board[7][7] = new Rook(a, 7, 7);
        
        //knights
        board[0][1] = new Knight(b, 0 ,1);
        board[0][6] = new Knight(b, 0, 6);
        board[7][1] = new Knight(a, 7, 1);
        board[7][6] = new Knight(a, 7, 6);
        
        //bishops
        board[0][2] = new Bishop(b, 0, 2);
        board[0][5] = new Bishop(b, 0, 5);
        board[7][2] = new Bishop(a, 7, 2);
        board[7][5] = new Bishop(a, 7, 5);
        
        //kings
        board[0][3] = new King(b, 0, 3);
        board[7][3] = new King(a, 7, 3);
        
        //queens
        board[0][4] = new Queen(b, 0, 4);
        board[7][4] = new Queen(a, 7, 4);
        
    }
    
    public void Draw()
    {
//        for(int r = 8; r >= 0; r--)
//        {
//            for( int c = 0; c <= 8; c++)
//            {
//                System.out.print(" ");
//                if(r < 8 && c < 8)
//                {
//                    if (board[r][c] != null) System.out.print(board[r][c].symbol);
//                    else System.out.print(" ");
//                }
//                else 
//                {
//                    if (c < 8) System.out.print((char)(65 + c));
//                    else if (r < 8) System.out.print(r + 1);
//                }
//            }
//            System.out.print("\n");
//        }
        
        this.setLayout(new GridLayout(8, 8));
        buttons = new JButton[64];
        
        int i = 0;
        while ( i < 64){
            
            for(int r = 7; r >= 0; r--)
            {
                for( int c = 0; c < board.length; c++)
                {   
                    if (board[r][c] != null) buttons[i] = new JButton(Character.toString(board[r][c].symbol));
                    else buttons[i] = new JButton("");
                    buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
                    this.add(buttons[i]);
                    i++;
                }
            }
        }
    }
    
}

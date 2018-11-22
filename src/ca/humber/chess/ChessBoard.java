/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChessBoard extends JPanel
{
    ChessPiece[][] board;
    String player;
    int row1 = -1, row2 = -1, column1 = -1, column2 = -1;
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
    
    public boolean Turn(String player, char c1, int r1, char c2, int r2) 
    {
        //convert chars
        int col1 = c1 - 65;
        int col2 = c2 - 65;
        
        //check if there is a piece at that spot
        if(board[r1][col1] != null)
        {
            if(board[r1][col1].colour.equals(player))
            {
                //check if that piece can move to specified spot
                if ((board[r2][col2] != null && !board[r2][col2].colour.equals(player)) || board[r2][col2] == null) 
                {
                    if (board[r1][col1].CanMoveTo(r2, col2, board)) 
                    {
                        board[r1][col1].MoveTo(r2, col2);
                        board[r2][col2] = board[r1][col1];
                        board[r1][col1] = null;
                        return true;
                    }
                    else System.out.println("illegal move");
                }
            }
        }
        return false;
    }
      
    public boolean Turn(int c1, int r1, int c2, int r2)
    {
        //check if there is a piece at that spot
        if (board[r1][c1] != null)
        {
            if (board[r1][c1].colour.equals(player)) 
            {
                //check if that piece can move to specified spot
                if ((board[r2][c2] != null && !board[r2][c2].colour.equals(player)) || board[r2][c2] == null) 
                {
                    if (board[r1][c1].CanMoveTo(r2, c2, board)) 
                    {
                        board[r1][c1].MoveTo(r2, c2);
                        board[r2][c2] = board[r1][c1];
                        board[r1][c1] = null;
                        return true;
                    } 
                    else { System.out.println("illegal move"); }
                } 
                else { System.out.println("piece in way"); }
            } 
            else { System.out.println("wrong player move"); }
        } 
        else { System.out.println("no piece selected"); }

        return false;
    }
      
    public boolean GameOver() 
    {
        //check if game is over
        int kings = 0;
        //count kings
        for (int r = 0; r < board.length; r++) 
        {
            for (int c = 0; c < board.length; c++)
            {
                if (board[r][c] != null) 
                {
                    if (board[r][c].symbol == 'x' || board[r][c].symbol == 'X') 
                    {
                        kings++;
                    }
                }
            }
        }

        if (kings < 2) { return true; }
        return false;
    }
       
    public void Draw()
    {
        this.removeAll();
        this.setLayout(new GridLayout(8, 8));
        buttons = new JButton[64];
        
        Icon BBishop = new ImageIcon("Images/BBishop.jpg");
        Icon BKing = new ImageIcon("Images/BKing.jpg");
        Icon BKnight = new ImageIcon("Images/BKnight.jpg");
        Icon BPawn = new ImageIcon("Images/BPawn.jpg");
        Icon BQueen = new ImageIcon("Images/BQueen.jpg");
        Icon BRook = new ImageIcon("Images/BRook.jpg");
        
        Icon WBishop = new ImageIcon("Images/WBishop.jpg");
        Icon WKing = new ImageIcon("Images/WKing.jpg");
        Icon WKnight = new ImageIcon("Images/WKnight.jpg");
        Icon WPawn = new ImageIcon("Images/WPawn.jpg");
        Icon WQueen = new ImageIcon("Images/WQueen.jpg");
        Icon WRook = new ImageIcon("Images/WRook.jpg");

        
        int i = 0;
        while ( i < 64)
        {
            for(int r = 0; r <= 7; r++)
            {
                for( int c = 0; c < board.length; c++)
                {   
                    if (board[r][c] != null) 
                    {            
                        String val = Character.toString(board[r][c].symbol);
                        switch(val)
                        {
                            case "B":
                                buttons[i] = new JButton(BBishop);
                                break;
                            case "R":
                                buttons[i] = new JButton(BRook);
                                break;
                            case "K":
                                buttons[i] = new JButton(BKnight);
                                break;                                
                            case "Q":
                                buttons[i] = new JButton(BQueen);
                                break;                                
                            case "X":
                                buttons[i] = new JButton(BKing);
                                break;                                
                            case "P":
                                buttons[i] = new JButton(BPawn);
                                break;   
                            case "b":
                                buttons[i] = new JButton(WBishop);
                                break;                               
                            case "r":
                                buttons[i] = new JButton(WRook);
                                break;                            
                            case "k":
                                buttons[i] = new JButton(WKnight);
                                break;                                
                            case "q":
                                buttons[i] = new JButton(WQueen);
                                break;                                
                            case "x":
                                buttons[i] = new JButton(WKing);
                                break;                                
                            case "p":
                                buttons[i] = new JButton(WPawn);
                                break;                                
                            default:
                                buttons[i] = new JButton("");
                                break;
                        }
                    } 
                    else { buttons[i] = new JButton(""); }

                    buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
                    buttons[i].setName(Integer.toString(i));
                    this.add(buttons[i]);
                    validate();
                    setVisible(true);
                    
                    repaint();
                    
                    buttons[i].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent ae) 
                        {
                            JButton currentButton = (JButton)ae.getSource();
                            int currentR = -1, currentC = -1;
                          
                            int x = Integer.parseInt(currentButton.getName());
                            System.out.print("\n");
                            System.out.print(x);
                            System.out.print("\n");
                            for (int i = 0; (i * 8) < x; i++) 
                            {
                               currentR = i;
                               currentC = x - (i*8);
                               if (currentC == 8) 
                               {
                                   currentC = 0;
                                   currentR++;
                               }
                            }
                            if(currentC < 0) 
                            {
                                currentC = 0;
                                currentR = 0;
                            }
                            
                            //find first button coordinates
                            if(row1 < 0) 
                            {
                                row1 = currentR;
                                column1 = currentC;
                                
                                System.out.print("col1 ");
                                System.out.print(column1);
                                System.out.print("row1 ");
                                System.out.print(row1);
                            }
                            //find second button coordinates
                            else
                            {
                                row2 = currentR;
                                column2 = currentC;
                                
                                System.out.print("col2 ");
                                System.out.print(column2);
                                System.out.print("row2 ");
                                System.out.print(row2);
                                
                                //perform turn
                                if (Turn(column1, row1, column2, row2)) 
                                {
                                    if (player.equals("white")) { player = "black"; } 
                                    else { player = "white"; }
                                    Draw();
                                }
                                else { System.out.print("move not completed"); }
                                row1 = -1;
                                row2 = -1;
                                column1 = -1;
                                column2 = -1;
                                
                                if(GameOver()) JOptionPane.showConfirmDialog(currentButton, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
                            }
                        }
                    });
                    i++;
                }
            }
        }
    }
}

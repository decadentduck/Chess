/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager 
{
    ChessBoard chessBoard;
    public void Start()
    {
        //initialize
        chessBoard = new ChessBoard();
    }
    
    public void Run()
    {
        //tell it to start game
        boolean running = true;
        //set player one
        String player = "white";
        //create scanner
        Scanner sc = new Scanner(System.in);
        //check if there is a board
        if(chessBoard == null) chessBoard = new ChessBoard();
        
        //draw board
        chessBoard.Draw();
        
        //game loop
        while(running)
        {
            try
            {
                //player turn
                if(Turn(player, sc.next("[A-H]").charAt(0), sc.nextInt() -1, sc.next("[A-H]").charAt(0), sc.nextInt()-1))
                {
                    if(player.equals("white")) player = "black";
                    else player = "white";
                }
                //check win
                if(GameOver()) running = false;
            
                //draw board
                chessBoard.Draw();
            }
            catch(InputMismatchException ex)
            {
                System.out.println("incorrect input");
            }
        }
        System.out.println("Game Over");
    }
    
    public boolean Turn(String player, char c1,int r1 , char c2, int r2) 
    {
        //convert chars
        int col1 = c1 - 65;
        int col2 = c2 - 65;
        
        //check if there is a piece at that spot
        if(chessBoard.board[r1][col1] != null)
        {
            if(chessBoard.board[r1][col1].colour.equals(player))
            {
                System.out.println("player piece there");
                //check if that piece can move to specified spot
                if ((chessBoard.board[r2][col2] != null && !chessBoard.board[r2][col2].colour.equals(player)) || chessBoard.board[r2][col2] == null) 
                {
                    System.out.println("nothing in way");
                    if (chessBoard.board[r1][col1].CanMoveTo(r2, col2, chessBoard.board)) 
                    {
                        System.out.println("legal move");
                        chessBoard.board[r1][col1].MoveTo(r2, col2, chessBoard.board);
                        chessBoard.board[r2][col2] = chessBoard.board[r1][col1];
                        chessBoard.board[r1][col1] = null;
                        return true;
                    }
                    else System.out.println("illegal move");
                }
                else System.out.println("piece in way");
            }
            else System.out.println(" Enemy piece there");
        }
        else System.out.println("null piece");
        
        return false;
    }
    
    public boolean GameOver()
    {
        //check if game is over
        int kings = 0;
        //count kings
        for(int r = 0; r < chessBoard.board.length; r++)
        {
            for( int c = 0; c < chessBoard.board.length; c++)
            {
                if(chessBoard.board[r][c] != null) 
                {
                    if(chessBoard.board[r][c].symbol == 'x' || chessBoard.board[r][c].symbol == 'X') kings++;
                }
            }
        }
        
        if (kings < 2) return true;
        return false;
    }
}

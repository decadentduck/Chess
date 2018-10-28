/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager 
{
    ChessBoard chessBoard;
    String player;
    public void Start()
    {
        
    }
    
    public void CreateGame()
    {
        //initialize
        chessBoard = new ChessBoard();

        //set player one
        player = "white";
    }
    
    public void CreateGame(String filename)
    {
        
    }
    
    public void Run()
    {

        //create scanner
        Scanner sc = new Scanner(System.in);
        
        //TODO ask to start new game or load up an existing save file
        try
        {
            System.out.println("1 - Start New Game");
            System.out.println("2 - Load Saved Game");
            if(sc.nextInt() == 1) CreateGame();
            else if(sc.nextInt() == 2)
            {
                //TODO Show existing files
                //TODO create game from specified file
            }
        }
        catch(InputMismatchException ex)
        {
            System.out.println("Enter '1' or '2'");       
            sc.next();
        }
        
         //tell it to start game
        boolean running = true;
        
        //check if there is a board
        if(chessBoard == null) chessBoard = new ChessBoard();
        
        Instructions();
        
        //draw board
        chessBoard.Draw();
        
        //game loop
        while(running)
        {
            //TODO add option to save the game
            
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
                System.out.println("incorrect input, try again");
                Instructions();
                sc.next();
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
                //check if that piece can move to specified spot
                if ((chessBoard.board[r2][col2] != null && !chessBoard.board[r2][col2].colour.equals(player)) || chessBoard.board[r2][col2] == null) 
                {
                    if (chessBoard.board[r1][col1].CanMoveTo(r2, col2, chessBoard.board)) 
                    {
                        chessBoard.board[r1][col1].MoveTo(r2, col2);
                        chessBoard.board[r2][col2] = chessBoard.board[r1][col1];
                        chessBoard.board[r1][col1] = null;
                        return true;
                    }
                    else System.out.println("illegal move");
                }
            }
        }
        return false;
    }
    
    private void SaveGame(String fileName)
    {
        //saves playerturn and the symbol at each spot on the board
        File file = new File(fileName);  
        
        try(FileWriter f = new FileWriter(file);)
        {
            f.write(player);
            f.write(" ");
            for(ChessPiece row[]: chessBoard.board)
            {
                for(ChessPiece i : row)
                {
                    f.write(i.symbol);
                    f.write(" ");
                }
            }
        }
        catch(IOException ex)
        {
            
        }
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
    
    private void Instructions()
    {
        System.out.println("Instructions:");
        System.out.println("Enter the movement with the starting point first and the destination second");
        System.out.println("for example: 'A 2 A 3'");
    }
}

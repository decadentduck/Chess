/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class GameManager 
{
    ChessBoard chessBoard;
    String player;
    ChessPiece[][] board;
    
    public void Start()
    {
        MainMenu();
        Run();
    }
    
    private void CreateGame()
    {
        //initialize
        chessBoard = new ChessBoard();

        //set player one
        player = "white";
    }
    
    private void CreateGame(String fileName)
    {
        //set player one
        try (BufferedReader in = new BufferedReader(new FileReader(fileName));) 
        {
            String line;
            char[] symbols = new char[64];
            
            
            //read the lines
            while ((line = in.readLine()) != null) 
            {
                //Read the words
                StringTokenizer st = new StringTokenizer(line, " .'\"-,:;()[]{}`/*+");

                player = st.nextToken();
                
                int i = 0;
                while (st.hasMoreTokens()) 
                {
                    String word = st.nextToken();
                    symbols[i] = word.charAt(0);
                    i++;
                }
            }
            //initialize
            chessBoard = new ChessBoard(symbols);
        }
        catch(IOException s){System.out.println("Invalid file");}
        
        Run();
    }
    
    private boolean GameOver()
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
    
    private void MainMenu()
    {
        //create scanner
        Scanner sc = new Scanner(System.in);
        while(chessBoard == null)
        {
            //ask to start new game or load up an existing save file
            try
            {
                System.out.println("1 - Start New Game");
                System.out.println("2 - Load Saved Game");
                int i = sc.nextInt();
                if (i == 1) CreateGame();
                else if (i == 2) 
                {
                    //Show existing files
                    //create game from specified file
                    System.out.println("1 - Save Game 1");
                    System.out.println("2 - Save Game 2");
                    i = sc.nextInt();
                    if (i == 1) CreateGame("Save.txt");
                    else if (i == 2) CreateGame("Save0.txt");
                }
            }
            catch(InputMismatchException ex)
            {
                System.out.println("Enter '1' or '2'");       
                sc.next();
            }
        }
    }
    
    private void Run()
    {
        //create scanner
        Scanner sc = new Scanner(System.in);
        
        //tell it to start game
        boolean running = true;
        
        //check if there is a board
        if(chessBoard == null) MainMenu();
        
        Instructions();
        
        //draw board
        chessBoard.Draw();
        
        //game loop
        while(running)
        {
            try
            {
                String firstInput = sc.next();
                if (!firstInput.equals("save") && !firstInput.equals("A") && !firstInput.equals("B") && !firstInput.equals("C")
                        && !firstInput.equals("D") && !firstInput.equals("E") && !firstInput.equals("F") && !firstInput.equals("G") 
                        && !firstInput.equals("H")) { throw new InputMismatchException(); }
                else if(firstInput.equals("save"))
                {
                    SaveGame("save0.txt");
                    break;
                }
                //player turn
                else if(Turn(player, firstInput.charAt(0), sc.nextInt() -1, sc.next("[A-H]").charAt(0), sc.nextInt()-1))
                {
                    if(player.equals("white")) player = "black";
                    else player = "white";
                }
                else System.out.println("illegal move");
                    
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
                //draw board
                chessBoard.Draw();
            }
            
        }
        System.out.println("Game Closed");
        running = false;
    }
    
    private boolean Turn(String player, char c1, int r1, char c2, int r2) 
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
                    if(i!= null) f.write(i.symbol);
                    else f.write("a");
                    f.write(" ");
                }
            }
        }
        catch(IOException ex)
        {
            
        }
    }
    
    private void Instructions()
    {
        System.out.println("Instructions:");
        System.out.println("Enter the movement with the starting point first and the destination second");
        System.out.println("for example: 'A 2 A 3'");
        System.out.println("or enter 'save' to save the game");
    }
}

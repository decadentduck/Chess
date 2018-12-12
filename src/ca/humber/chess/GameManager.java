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
import javax.swing.JFrame;
import com.mysql.cj.jdbc.MysqlDataSource;

public class GameManager 
{
    ChessBoard chessBoard;
    ChessPiece[][] board;
    
    public void Start()
    {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/space_battle");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            DBConnectivity dbCon = new DBConnectivity(dataSource);
          //  dbCon.insertInfo();
            dbCon.startGame(2, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        MainMenu();
        Run();
    }
    
    private void CreateGame()
    {
        //initialize
        chessBoard = new ChessBoard();

        //set player one
        chessBoard.player = "black";
        
        //create window
        JFrame frame = new JFrame("Chess");
        frame.setContentPane(chessBoard);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 700, 700);
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

                chessBoard.player = st.nextToken();
                
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
            
            //create window
            JFrame frame = new JFrame("Chess");
            frame.setContentPane(chessBoard);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(200, 200, 800, 800);
        }
        catch(IOException s){System.out.println("Invalid file");}
        
        Run();
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
                    if (i == 1) CreateGame("Save1.txt");
                    else if (i == 2) CreateGame("Save2.txt");
                }
            }
            catch(InputMismatchException ex)
            {
                System.out.println("Enter '1' or '2'");       
                sc.next();
            }
        }
    }
    
    private void SaveMenu()
    {
        //create scanner
        Scanner sc = new Scanner(System.in);
        while(chessBoard != null)
        {
            //ask which save file to overwrite
            try
            {
                System.out.println("1 - Save as Game 1");
                System.out.println("2 - Save as Game 2");
                int i = sc.nextInt();
                if (i == 1) SaveGame("Save1.txt");
                else if (i == 2) SaveGame("Save2.txt");
                else throw new InputMismatchException();
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
                    SaveMenu();
                    running = false;
                    break;
                }
                //player turn
                else if(chessBoard.Turn(chessBoard.player, firstInput.charAt(0), sc.nextInt() -1, sc.next("[A-H]").charAt(0), sc.nextInt()-1))
                {
                    if(chessBoard.player.equals("white")) chessBoard.player = "black";
                    else chessBoard.player = "white";
                }
                else System.out.println("illegal move");
                    
                //check win
                if(chessBoard.GameOver()) running = false;
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
    
    private void SaveGame(String fileName)
    {
        //saves playerturn and the symbol at each spot on the board
        File file = new File(fileName);  
        
        try(FileWriter f = new FileWriter(file);)
        {
            f.write(chessBoard.player);
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
        chessBoard = null;
    }
    
    private void Instructions()
    {
        System.out.println("Instructions:");
        System.out.println("Enter the movement with the starting point first and the destination second");
        System.out.println("for example: 'A 2 A 3'");
        System.out.println("or enter 'save' to save the game");
    }
}

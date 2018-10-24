/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Chess 
{
    public static void main(String[] args) 
    {
        GameManager game = new GameManager();
        
        System.out.print("Enter the movement like: 'A 2 A 3' \n \n");
        
        game.Start();
        game.Run();
    }
}

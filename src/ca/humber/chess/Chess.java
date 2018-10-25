/*Created by Kaitlyn Ewing & Jeff Bonhoff*/
package ca.humber.chess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Chess 
{
    public static void main(String[] args) 
    {
        GameManager game = new GameManager();
        System.out.println("Instructions:");
        System.out.println("Enter the movement with the starting point first and the destination second");
        System.out.println("for example: 'A 2 A 3'");
        
        game.Start();
        game.Run();
    }
}

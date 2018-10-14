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
public class Pawn extends ChessPiece
{
    boolean firstMove;
    public Pawn(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'P';
        else symbol = 'p';
        firstMove = true;
    }
    
    @Override
    public Boolean CheckMove(char c1_, int y1_, char c2_, int y2_)
    {
        int x1 = c1_;
        int x2 = c2_;
        
        if (colour.equals("white")) 
        {
            if (firstMove)
            {
                //apparently a pawn can move two spaces forwards, but only the first time it moves
                if (x1 != x2 || y2 - y1 > 2) return false;
                else firstMove = false;
            }
            if (x1 != x2 || y1 != y2 + 1) return false;
        } 
        else 
        {
            if (firstMove)
            {
                //apparently a pawn can move two spaces forwards, but only the first time it moves
                if (x1 != x2 || y1 - y2 > 2) return false;
                else firstMove = false;
            }
            if (x1 != x2 || y1 != y2 - 1) return false;
        }
        
        return true;
    }
}

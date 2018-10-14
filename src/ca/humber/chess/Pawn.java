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
    public Pawn(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'P';
        else symbol = 'p';
    }
    
    @Override
    public Boolean CheckMove(char x1_, int y1_, char x2_, int y2_)
    {
        //apparently a pawn can move two spaces forwards, but only the first time it moves
        
        if (colour.equals("white")){if(x1 != x2 || y1 != y2+1){return false;}}
        else{if(x1 != x2 || y1 != y2-1){return false;}}
        
        return true;
    }
}

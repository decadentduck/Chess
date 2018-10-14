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
    public Boolean CheckMove(char x1, int y1, char x2, int y2)
    {
        return true;
    }
}

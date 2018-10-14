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
public class Rook extends ChessPiece
{
    public Rook(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'R';
        else symbol = 'r';
    }
    
    @Override
    public Boolean CheckMove(char x1, int y1, char x2, int y2)
    {
        return true;
    }
}
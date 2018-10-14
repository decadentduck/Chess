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
public class Queen extends ChessPiece
{
    public Queen(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'Q';
        else symbol = 'q';
    }
    
    @Override
    public Boolean CheckMove(char x1, int y1, char x2, int y2)
    {
        return true;
    }
}

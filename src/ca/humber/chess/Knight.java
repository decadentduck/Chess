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
public class Knight extends ChessPiece
{
    public Knight(String colour_) 
    {
        colour = colour_;
        if(colour.equals("white")) symbol = 'K';
        else symbol = 'k';
    }
    
    @Override
    public Boolean CheckMove(char c1_, int y1_, char c2_, int y2_)
    {
        int x1 = c1_;
        int x2 = c2_;
        return true;
    }
}
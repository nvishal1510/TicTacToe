package com.tictactoe;

public class Grid
{
    private Player[][] mGrid;

    public Grid ()
    {
        mGrid = new Player[3][3];
    }


    public boolean markGrid (int row, int column, Player player) throws IllegalArgumentException,ArrayIndexOutOfBoundsException
    {
        if (mGrid[row][column] != Player.NONE)
            throw new IllegalArgumentException("The grid is already marked");
        mGrid[row][column]=player;
        return true;
    }

    public Player getGridElement (int row, int column)
    {
        return mGrid[row][column];
    }
}

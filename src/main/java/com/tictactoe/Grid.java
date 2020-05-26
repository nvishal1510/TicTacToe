package com.tictactoe;

public class Grid
{
    private final Player[][] mGrid;

    /**
     * initializes the grid with Player.NONE
     */
    public Grid ()
    {
        mGrid = new Player[3][3];

        //initialise grid
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                mGrid[i][j] = Player.NONE;

    }

    private void setGridElement (int row, int column, Player player)
    {
        mGrid[row][column] = player;
    }

    /**
     * Marks the grid at the specified box row and column with the specified player
     *
     * @param row
     * @param column
     * @param player
     * @return true - if successfully marked<br>
     * false - if it is already marked
     * @throws ArrayIndexOutOfBoundsException when row or column is not in range(0,3)
     */
    public boolean markGrid (int row, int column, Player player) throws ArrayIndexOutOfBoundsException
    {
        if (getGridElement(row, column) != Player.NONE)
            return false;
        setGridElement(row, column, player);
        return true;
    }

    public Player getGridElement (int row, int column)
    {
        return mGrid[row][column];
    }

    /**
     * Checks if someone won by checking rows, columns and diagonals for same type of markings
     *
     * @return Player.NONE if none of the players won <br>
     * Player.PLAYER1, Player.PLAYER2, Player.COMPUTER if player1, player2, player3 won respectively
     */
    public Player checkWin ()
    {
        //checks rows
        for (int row = 0; row < 3; row++)
            if (getGridElement(row, 0) == getGridElement(row, 1) &&
                    getGridElement(row, 0) == getGridElement(row, 1) &&
                    getGridElement(row, 0) != Player.NONE)
                return getGridElement(row, 0);

        //checks columns
        for (int column = 0; column < 3; column++)
            if (getGridElement(0, column) == getGridElement(1, column) &&
                    getGridElement(1, column) == getGridElement(2, column) &&
                    getGridElement(0, column) != Player.NONE)
                return getGridElement(0, column);

        //checks diagonals
        if (getGridElement(0, 0) == getGridElement(1, 1) &&
                getGridElement(1, 1) == getGridElement(2, 2) &&
                getGridElement(0, 0) != Player.NONE)
            return getGridElement(0, 0);
        if (getGridElement(2, 0) == getGridElement(1, 1) &&
                getGridElement(1, 1) == getGridElement(0, 2) &&
                getGridElement(0, 0) != Player.NONE)
            return getGridElement(2, 0);

        return Player.NONE;

    }

    /**
     * Checks if all the box in the grid are marked by some player
     *
     * @return true if all the boxes are marked<br>
     * false if at least one box is not marked
     */
    public boolean isfull ()
    {
        for (int row = 0; row < 3; row++)
            for (int column = 0; column < 3; column++)
                if (getGridElement(row, column) == Player.NONE)
                    return false;

        return true;
    }
}

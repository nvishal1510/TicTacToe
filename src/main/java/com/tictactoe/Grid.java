package com.tictactoe;

public class Grid
{
    private final Move[][] mGrid;

    /**
     * initializes the all the elements of grid with Player.NONE
     */
    public Grid ()
    {
        mGrid = new Move[3][3];
        for (int row = 0; row < 3; row++)
            for (int column = 0; column < 3; column++)
                mGrid[row][column] = new Move(Player.NONE, row, column);
    }

    /**
     * Setter method for Grid Element with param player and moveToBePlayed
     */
    private void setGridElement (int row, int column, Player player)
    {
        mGrid[row][column] = new Move(player, row, column);
    }

    /**
     * Getter method for different elements of grid
     *
     * @return the move in grid at the row and column
     */
    public Move getGridElement (int row, int column)
    {
        return mGrid[row][column];
    }

    /**
     * Marks the grid at the specified box row and column with the specified player
     * and also increments the moveToBePlayed
     *
     * @param player Player to mark the grid with
     * @return true - if successfully marked<br>
     * false - if it is already marked
     * @throws ArrayIndexOutOfBoundsException when row or column is not in range(0,3)
     */
    public boolean markGrid (int row, int column, Player player) throws ArrayIndexOutOfBoundsException
    {
        if (getGridElement(row, column).getPlayer() != Player.NONE)
            return false;
        setGridElement(row, column, player);
        return true;
    }

    /**
     * Checks if someone won by checking rows, columns and diagonals for move by same player
     *
     * @return Player.NONE if none of the players won <br>
     * Player.PLAYER1, Player.PLAYER2, Player.COMPUTER if player1, player2, player3 won respectively
     */
    public Player checkWin ()
    {
        //checks rows
        for (int row = 0; row < 3; row++)
            if (getGridElement(row, 0).getPlayer() == getGridElement(row, 1).getPlayer() &&
                    getGridElement(row, 1).getPlayer() == getGridElement(row, 2).getPlayer() &&
                    getGridElement(row, 0).getPlayer() != Player.NONE)
                return getGridElement(row, 0).getPlayer();

        //checks columns
        for (int column = 0; column < 3; column++)
            if (getGridElement(0, column).getPlayer() == getGridElement(1, column).getPlayer() &&
                    getGridElement(1, column).getPlayer() == getGridElement(2, column).getPlayer() &&
                    getGridElement(0, column).getPlayer() != Player.NONE)
                return getGridElement(0, column).getPlayer();

        //checks diagonals
        if (getGridElement(0, 0).getPlayer() == getGridElement(1, 1).getPlayer() &&
                getGridElement(1, 1).getPlayer() == getGridElement(2, 2).getPlayer() &&
                getGridElement(0, 0).getPlayer() != Player.NONE)
            return getGridElement(0, 0).getPlayer();
        if (getGridElement(2, 0).getPlayer() == getGridElement(1, 1).getPlayer() &&
                getGridElement(1, 1).getPlayer() == getGridElement(0, 2).getPlayer() &&
                getGridElement(0, 0).getPlayer() != Player.NONE)
            return getGridElement(2, 0).getPlayer();

        return Player.NONE;
    }

    /**
     * Checks if all the box in the grid are marked by some player
     *
     * @return true if all the boxes are marked<br>
     * false if at least one box is not marked
     */
    public boolean isFull ()
    {
        for (int row = 0; row < 3; row++)
            for (int column = 0; column < 3; column++)
                if (getGridElement(row, column).getPlayer() == Player.NONE)
                    return false;

        return true;
    }

    /**
     * Initialises all the elements of the grid with new Move() to remove player and moveNum to all the elements of
     * the Grid
     */
    public void clear ()
    {
        for (int row = 0; row < 3; row++)
            for (int column = 0; column < 3; column++)
                mGrid[row][column] = new Move(row, column);
        Move.clear();

    }

}

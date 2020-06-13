package com.tictactoe;

import java.util.Stack;

public class Move
{
    /**
     * This stores the moves played by the Players
     */
    private static final Stack<Move> playedMoveStack = new Stack<>();
    private final Player player;
    private final int row;
    private final int column;

    public Move (Player player, int row, int column)
    {
        this.player = player;
        this.row = row;
        this.column = column;
        if (player != Player.NONE)
        {
            playedMoveStack.push(this);
        }
    }

    public Move (int row, int column)
    {
        this(Player.NONE, row, column);
    }

    public static int getPlayedMoveStackSize ()
    {
        return playedMoveStack.size();
    }

    /**
     * Clear all the records of moves played with Move.java
     */
    public static void clear ()
    {
        playedMoveStack.clear();
    }

    public int getRow ()
    {
        return row;
    }

    public int getColumn ()
    {
        return column;
    }

    public Player getPlayer ()
    {
        return player;
    }
}

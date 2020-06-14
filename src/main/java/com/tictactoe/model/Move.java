package com.tictactoe.model;

import java.util.EmptyStackException;
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

    static int getPlayedMoveStackSize ()
    {
        return playedMoveStack.size();
    }

    /**
     * Clear all the records of moves played with Move.java
     */
    static void clear ()
    {
        playedMoveStack.clear();
    }

    /**
     * Undos last move, i.e removes its last played move record
     *
     * @return last played move
     */
    static Move undoLastMove () throws UnsupportedOperationException
    {
        try
        {
            return playedMoveStack.pop();
        } catch (EmptyStackException e)
        {
            throw new UnsupportedOperationException("There are no moves to undo", e);
        }
    }

    /**
     * @return row at which Move is placed
     */
    public int getRow ()
    {
        return row;
    }
    /**
     * @return column at which Move is placed
     */
    public int getColumn ()
    {
        return column;
    }

    /**
     * @return Player who played the move
     */
    public Player getPlayer ()
    {
        return player;
    }
}

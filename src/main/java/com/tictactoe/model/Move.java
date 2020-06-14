package com.tictactoe.model;

import java.util.EmptyStackException;
import java.util.Stack;

public class Move
{
    /**
     * This stores the moves played by the Players
     */
    private static final Stack<Move> playedMoveStack = new Stack<>();
    /**
     * This stores the undone moves
     */
    private static final Stack<Move> undoneMoveStack = new Stack<>();
    private final Player player;
    private final int row;
    private final int column;

    public Move (Player player, int row, int column)
    {
        this.player = player;
        this.row = row;
        this.column = column;
        if (player != Player.NONE)
            playedMoveStack.push(this);
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
        undoneMoveStack.clear();
    }

    /**
     * Undos last move, i.e removes its last played move record
     *
     * @return last played move
     */
    static Move undoMove () throws UnsupportedOperationException
    {
        try
        {
            Move lastMove = playedMoveStack.pop();
            undoneMoveStack.push(lastMove);
            return lastMove;
        } catch (EmptyStackException e)
        {
            throw new UnsupportedOperationException("There are no moves to undo", e);
        }
    }

    /**
     * Redos last move, i.e replays last undone move
     *
     * @return redone move
     */
    static Move redoMove () throws UnsupportedOperationException
    {
        try
        {
            Move move = undoneMoveStack.pop();
            playedMoveStack.push(move);
            return move;
        } catch (EmptyStackException e)
        {
            throw new UnsupportedOperationException("There are no moves to redo", e);
        }
    }

    /**
     * Clears record of all undone moves
     */
    static void clearUndoneMoveStack ()
    {
        undoneMoveStack.clear();
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

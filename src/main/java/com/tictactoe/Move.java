package com.tictactoe;

import java.util.Stack;

public class Move
{
    /**
     * This stores the moves played by the Players
     */
    private static final Stack<Move> playedMoveStack = new Stack<>();
    private final Player player;

    public Move (Player player)
    {
        this.player = player;
        if (player == Player.NONE)
        {
            playedMoveStack.push(this);
        }
    }

    public Move ()
    {
        this(Player.NONE);
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

    public Player getPlayer ()
    {
        return player;
    }
}

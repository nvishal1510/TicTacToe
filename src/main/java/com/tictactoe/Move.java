package com.tictactoe;

public class Move
{
    private Player player;
    private int moveNum;

    public Move (Player player, int moveNum)
    {
        this.player = player;
        this.moveNum = moveNum;
    }

    public Move ()
    {
        this(Player.NONE,0);
    }

    public Player getPlayer ()
    {
        return player;
    }

    public void setPlayer (Player player)
    {
        this.player = player;
    }

    public int getMoveNum ()
    {
        return moveNum;
    }

    public void setMoveNum (int moveNum)
    {
        this.moveNum = moveNum;
    }
}

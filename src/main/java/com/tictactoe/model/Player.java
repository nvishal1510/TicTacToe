package com.tictactoe.model;

public enum Player
{
    COMPUTER("Computer"), NONE("None"), PLAYER1("Player 1"), PLAYER2("Player 2");

    private final String friendlyName;

    Player (String friendlyName)
    {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString ()
    {
        return friendlyName;
    }

}

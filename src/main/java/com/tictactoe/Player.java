package com.tictactoe;

public enum Player
{
    COMPUTER
            {
                @Override
                public String toString ()
                {
                    return "Computer";
                }
            },
    NONE
            {
                @Override
                public String toString ()
                {
                    return "None";
                }
            },
    PLAYER1
            {
                @Override
                public String toString ()
                {
                    return "Player 1";
                }
            },
    PLAYER2
            {
                @Override
                public String toString ()
                {
                    return "Player 2";
                }
            }


}

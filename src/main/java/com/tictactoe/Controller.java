package com.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.Stack;

public class Controller
{
    //grid to store players marking
    private Grid grid;

    //This represents the player whose who is currently playing
    private Player playerPlaying;

    @FXML
    private GridPane buttonsGrid;

    @FXML
    private StackPane stackPane00;


    public Controller ()
    {
        grid = new Grid();
        playerPlaying = Player.PLAYER1;
    }


    /**
     * This handles click of a button on grid
     */
    @FXML
    private void gridClick (ActionEvent actionEvent)
    {
        if (!grid.isfull() && grid.checkWin() == Player.NONE)
        {
            Button buttonClicked = (Button) actionEvent.getSource();
            //box row where button is clicked
            int row = GridPane.getRowIndex(buttonClicked);
            //box column where button is clicked
            int column = GridPane.getColumnIndex(buttonClicked);

            if (grid.markGrid(row, column, playerPlaying))
            {
                markBox(buttonClicked);

                playerPlaying = (playerPlaying == Player.PLAYER1) ? Player.PLAYER2 : Player.PLAYER1;
                if (grid.checkWin() != Player.NONE)
                {
                    System.out.println(grid.checkWin() + " won");
                    //todo: alert box showing player won
                }
                else if (grid.isfull())
                {
                    System.out.println("draw");
                    //todo declare draw
                }

            }
            else
            {
                System.out.println("already marked");
                //todo : show a toast saying this grid is already marked
            }
        }
        else
        {
            //todo:say game has ended to the user
            System.out.println("The game has ended");
        }
    }

    private void markBox (Button buttonClicked)
    {
        if (playerPlaying == Player.PLAYER1)
        {
            buttonClicked.setText("X");
            buttonClicked.setFont(Font.font("Comic Sans MS",60));
        }
        else
        {
            buttonClicked.setText("O");
            buttonClicked.setFont(Font.font("Ebrima",60));
        }
    }


    private void print (String message)
    {
        System.out.println(message);
    }

    @FXML
    private void new1PlayerGame (ActionEvent actionEvent)
    {
        print("New 1 player game");
    }

    @FXML
    private void new2PlayerGame (ActionEvent actionEvent)
    {
        print("New 2 player game");
    }

    public void openGame (ActionEvent actionEvent)
    {
        print("open game");
    }

    public void saveGame (ActionEvent actionEvent)
    {
        print("Save game");
    }

    public void undoChange (ActionEvent actionEvent)
    {
        print("Undo");
    }

    public void redoChange (ActionEvent actionEvent)
    {
        print("Redo");
    }


}

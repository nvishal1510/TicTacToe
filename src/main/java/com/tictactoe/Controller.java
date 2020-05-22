package com.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Controller
{
    //grid to store players marking
    private Grid grid;

    //This represents the player whose who is currently playing
    private Player playerPlaying;

    @FXML
    private GridPane buttonsGrid;


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
            //box row where button is clicked
            int row = GridPane.getRowIndex((Node) actionEvent.getSource());
            //box column where button is clicked
            int column = GridPane.getColumnIndex((Node) actionEvent.getSource());

            if (grid.markGrid(row, column, playerPlaying))
            {
                //set mark on the Button
                Image mark;
                if (playerPlaying == Player.PLAYER1)
                    mark = new Image(getClass().getResourceAsStream("x.png"));
                else
                    mark = new Image(getClass().getResourceAsStream("circle.png"));
                Button buttonClicked = (Button) actionEvent.getSource();
                ImageView imageView = new ImageView(mark);
                imageView.setFitHeight(buttonClicked.getHeight());  // todo: check this method for errors
                imageView.setFitWidth(buttonClicked.getWidth());
                buttonClicked.setGraphic(imageView);

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
        else {
            //todo:say game has ended to the user
            System.out.println("The game has ended");
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

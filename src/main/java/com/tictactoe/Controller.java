package com.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Controller
{
    /**
     * grid to store players marking
     */
    private final Grid grid;

    /**
     * This represents the player whose who is currently playing
     */
    private Player playerPlaying;

    @FXML
    private GridPane buttonsGrid;


    /**
     * Initialise grid using Grid()
     * and playerPlaying to Player.PLAYER1
     */
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
        if (!grid.isFull() && grid.checkWin() == Player.NONE)
        {
            Button buttonClicked = (Button) actionEvent.getSource();

            int row = GridPane.getRowIndex(buttonClicked);
            int column = GridPane.getColumnIndex(buttonClicked);

            if (grid.markGrid(row, column, playerPlaying))
            {
                //mark the box on the visible GUI
                markBox(buttonClicked);

                playerPlaying = (playerPlaying == Player.PLAYER1) ? Player.PLAYER2 : Player.PLAYER1;
                if (grid.checkWin() != Player.NONE)
                {
                    System.out.println(grid.checkWin() + " won");
                    showNotification(2, String.format("Congratulations %s you have won!", grid.checkWin()));
                }
                else if (grid.isFull())
                    showNotification(2, "The game ended in a draw!");
            }
            else
                showNotification(1, String.format("This grid is already marked by %s!",
                        grid.getGridElement(row, column).getPlayer()));
        }
        else
        {
            System.out.println("The game has already ended");
            showNotification(2, String.format("The game has already ended!\nThe game is won by %s!", grid.checkWin()));
        }
    }

    private void showNotification (int time, String message)
    {
        Notifications.create()
                .hideAfter(Duration.seconds(time))
                .text(message)
                .owner(buttonsGrid)
                .show();
    }

    /**
     * Used by gridClick to simplify the code
     * if {@code playerPlaying == Player.PLAYER1} change the text on the button clicked to X <br>
     * else if {@code playerPlaying == Player.PLAYER2} change the text on the button clicked to O
     */
    private void markBox (Button buttonClicked)
    {
        if (playerPlaying == Player.PLAYER1)
        {
            buttonClicked.setText("X");
            buttonClicked.setFont(Font.font("Comic Sans MS", 60));
        }
        else
        {
            buttonClicked.setText("O");
            buttonClicked.setFont(Font.font("Ebrima", 60));
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

    /**
     * Start a new 2 Player game<br>
     * This is called by button in menu in GUI
     */
    @FXML
    private void new2PlayerGame (ActionEvent actionEvent)
    {
        print("New 2 player game");
        unmarkBox();
        grid.clear();
        playerPlaying = Player.PLAYER1;
    }

    /**
     * Removes all the text on the GUI
     * It restores the initial state of the visible grid
     */
    private void unmarkBox ()
    {
        for (Node node : buttonsGrid.getChildren())
        {
            Button button = (Button) node;
            button.setText("");
        }
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


    public void showAbout (ActionEvent actionEvent)
    {
        //todo: add a about page
    }
}

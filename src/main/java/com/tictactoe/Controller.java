package com.tictactoe;

import com.tictactoe.model.Grid;
import com.tictactoe.model.Move;
import com.tictactoe.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.util.NoSuchElementException;

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
     * Initialise grid using Grid() and playerPlaying to Player.PLAYER1
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
        if (grid.isFull() || grid.checkWin() != Player.NONE)
        {
            showNotification(2, String.format("The game has already ended!\nThe game is won by %s!", grid.checkWin()));
            return;
        }

        Button buttonClicked = (Button) actionEvent.getSource();
        int row = GridPane.getRowIndex(buttonClicked);
        int column = GridPane.getColumnIndex(buttonClicked);

        if (!grid.markGrid(row, column, playerPlaying))
        {
            showNotification(1, String.format("This grid is already marked by %s!",
                    grid.getGridElement(row, column).getPlayer()));
            return;
        }

        markBox(buttonClicked, playerPlaying);

        swapPlayerPlaying();

        if (grid.checkWin() != Player.NONE)
            showNotification(2, String.format("Congratulations %s you have won!", grid.checkWin()));
        else if (grid.isFull())
            showNotification(2, "The game ended in a draw!");
    }

    /**
     * Swaps the value of {@link #playerPlaying} with other Player
     */
    private void swapPlayerPlaying ()
    {
        playerPlaying = (playerPlaying == Player.PLAYER1) ? Player.PLAYER2 : Player.PLAYER1;
    }

    /**
     * Shows notifications at the right bottom of buttonGrid
     *
     * @param time    Duration in seconds for which notification is to be shown
     * @param message Message to be shown when notification is shown
     */
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
    private void markBox (Button buttonClicked, Player player)
    {
        switch (player)
        {
            case PLAYER1 -> {
                buttonClicked.setText("X");
                buttonClicked.setFont(Font.font("Comic Sans MS", 60));
            }
            case PLAYER2 -> {
                buttonClicked.setText("O");
                buttonClicked.setFont(Font.font("Ebrima", 60));
            }
            case NONE -> buttonClicked.setText("");
        }
    }

    @FXML
    private void new1PlayerGame (ActionEvent actionEvent)
    {
        System.out.println("New 1 player game");
    }

    /**
     * Start a new 2 Player game<br>
     * This is called by button in menu in GUI
     */
    @FXML
    private void new2PlayerGame (ActionEvent actionEvent)
    {
        unmarkBoxes();
        grid.clear();
        playerPlaying = Player.PLAYER1;
    }

    /**
     * Removes all the text on the GUI
     * It restores the initial state of the visible grid
     */
    private void unmarkBoxes ()
    {
        for (Node node : buttonsGrid.getChildren())
        {
            Button button = (Button) node;
            button.setText("");
        }
    }

    /**
     * This function is called by the click of the undo in GUI
     */
    @FXML
    private void undoChange (ActionEvent actionEvent)
    {
        try
        {
            Move lastMove = grid.undoMove();
            swapPlayerPlaying();
            markBox(getButtonFromButtonsGrid(lastMove.getRow(), lastMove.getColumn()), Player.NONE);
        }
        catch (UnsupportedOperationException e)
        {
            showNotification(2, e.getMessage());
        }
    }

    /**
     * This function is called by the click of the redo in GUI
     */
    @FXML
    private void redoChange (ActionEvent actionEvent)
    {
        try
        {
            Move redoneMove = grid.redoMove();
            swapPlayerPlaying();
            markBox(getButtonFromButtonsGrid(redoneMove.getRow(), redoneMove.getColumn()), redoneMove.getPlayer());
            if (grid.checkWin() != Player.NONE)
                showNotification(2, String.format("Congratulations %s you have won!", grid.checkWin()));
            else if (grid.isFull())
                showNotification(2, "The game ended in a draw!");
        }
        catch (UnsupportedOperationException e)
        {
            showNotification(2, e.getMessage());
        }
    }

    /**
     * Fetches the button in {@code GridPane buttonsGrid} using its row and column<br>
     * This uses brute force method, i.e, compares row and column with all elements in buttonsGrid<br>
     * Could have been made by loading all the buttons into various variable but that messes up the code
     *
     * @return Button in buttonsGrid at given row and column
     * @throws NoSuchElementException If there is no button at the given row and column
     */
    private Button getButtonFromButtonsGrid (int row, int column)
    {
        for (Node node : buttonsGrid.getChildren())
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column)
                return (Button) node;

        throw new NoSuchElementException("The button marked was not found");
    }

    @FXML
    private void showAbout (MouseEvent actionEvent)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("Developed by Vishal Neeli\n" +
                "Github:\n" +
                "https://github.com/nvishal1510\n" +
                "Facebook:\n" +
                "https://www.facebook.com/nvishal9");
        alert.show();
    }
}

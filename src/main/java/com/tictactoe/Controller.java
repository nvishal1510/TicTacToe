package com.tictactoe;

public class Controller
{
    @FXML
    private Button gridButton00;
    @FXML
    private Button gridButton01;
    @FXML
    private Button gridButton02;
    @FXML
    private Button gridButton10;
    @FXML
    private Button gridButton11;
    @FXML
    private Button gridButton12;
    @FXML
    private Button gridButton20;
    @FXML
    private Button gridButton21;
    @FXML
    private Button gridButton22;

    private Player playerPlaying;


    @FXML
    public void gridClick (ActionEvent actionEvent)
    {
        boolean result;
        switch (actionEvent.getSource())
        {
            case gridButton00:
                result = Main.gridClick(0, 1, playerPlaying);
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

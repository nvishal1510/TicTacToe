package com.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmBox
{
    static Boolean answer;

    public static Boolean display (String title, String message)
    {
        Stage confirmBox = new Stage();
        confirmBox.setTitle(title);
        confirmBox.initModality(Modality.APPLICATION_MODAL);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e ->
        {
            answer = true;
            confirmBox.close();
        });

        Button noButton = new Button("No");
        noButton.setOnAction(e ->
        {
            answer = false;
            confirmBox.close();
        });

        HBox buttonLayout = new HBox(20);
        buttonLayout.getChildren().addAll(yesButton, noButton);
        buttonLayout.setAlignment(Pos.CENTER);

        Label label = new Label(message);
        label.setFont(Font.font(14));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, buttonLayout);

        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(500, 100);

        Scene scene = new Scene(layout);
        confirmBox.setScene(scene);
        confirmBox.showAndWait();

        return answer;

    }
}




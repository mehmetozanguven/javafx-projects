package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private Label message;
    private int clickCount;

    @Override
    public void start(Stage stage) {
        Checkerboard checkerboard = new Checkerboard();
        checkerboard.drawBoard();

        Button newGame = new Button("New Game");
        newGame.setOnAction(e -> updateMessage());

        GridPane tilePane = new GridPane();
        message = new Label("Click \"New Game\" to begin.");
        message.setTextFill( Color.rgb(100,255,100) );
        message.setFont( Font.font(null, FontWeight.BOLD, 18) );

        checkerboard.relocate(20,20);
        newGame.relocate(370, 120);
        message.relocate(20, 370);

        newGame.setManaged(false);
        newGame.resize(100,50);

        Pane root = new Pane();
        root.setPrefHeight(500);
        root.setPrefWidth(500);
        root.getChildren().addAll(checkerboard, newGame, message);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void updateMessage() {
        clickCount++;
        message.setText("Click count: " + clickCount + ":  \"New Game\" was clicked.");
    }

    public static void main(String[] args) {
        launch();
    }
}
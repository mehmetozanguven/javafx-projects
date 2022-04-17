package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class App extends Application {
    private static final int CARD_WIDTH = 79;
    private static final int CARD_HEIGHT = 123;
    private static final int RANDOM_DEAL_NUMBER = 5;
    private static final int SPACE_BETWEEN_EACH_RANDOM_CARD = 20;
    private static final int CANVAS_WIDTH = (RANDOM_DEAL_NUMBER * CARD_WIDTH) +
                                            (RANDOM_DEAL_NUMBER * SPACE_BETWEEN_EACH_RANDOM_CARD) + SPACE_BETWEEN_EACH_RANDOM_CARD;

    private static final String BORDER_CSS = " -fx-border-color: blue;" +
            " -fx-border-width: 5;" +
            "-fx-border-style: segments(10, 15, 15, 15)  line-cap round";
    private Canvas canvas;
    private Image cardImage;

    @Override
    public void start(Stage stage) {
        cardImage = new Image("cards.png");
        canvas = new Canvas(CANVAS_WIDTH, CARD_HEIGHT + 50);
        drawOnCanvas();

        Button dealAgain = new Button("Deal Again !");
        dealAgain.setOnAction(event -> drawOnCanvas());

        StackPane bottom = new StackPane(dealAgain);
//        bottom.setStyle(BORDER_CSS);

        BorderPane root = new BorderPane(canvas);
        root.setBottom(bottom);
//        root.setStyle(BORDER_CSS);

        stage.setScene(new Scene(root, Color.BLACK));
        stage.setTitle("Random Cards");
        stage.show();
    }

    private void drawOnCanvas() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();    // 1
        double imageSourceXCoordinate, imageSourceYCoordinate;              // 2
        double imageSourceWidth = CARD_WIDTH;                               // 3
        double imageSourceHeight = CARD_HEIGHT;                             // 3

        double canvasDestinationXCoordinate, canvasDestinationYCoordinate;  // 4

        for (int randomDeal = 0; randomDeal < RANDOM_DEAL_NUMBER; randomDeal ++) {
            Card randomCard = Card.getRandomCard();                         // 5
            System.out.println(randomCard);
            imageSourceXCoordinate = CARD_WIDTH * (randomCard.value - 1);           // 6
            imageSourceYCoordinate = CARD_HEIGHT * ( randomCard.suit.value - 1);    // 7
            canvasDestinationXCoordinate = SPACE_BETWEEN_EACH_RANDOM_CARD + ( (CARD_WIDTH + SPACE_BETWEEN_EACH_RANDOM_CARD) * randomDeal);  // 8
            canvasDestinationYCoordinate = 20;  // 8
            graphicsContext.drawImage(cardImage, imageSourceXCoordinate, imageSourceYCoordinate, imageSourceWidth, imageSourceHeight,
                    canvasDestinationXCoordinate, canvasDestinationYCoordinate, CARD_WIDTH, CARD_HEIGHT ); // 9
        }
        System.out.println("------");

    }

    public static void main(String[] args) {
        launch();
    }

}
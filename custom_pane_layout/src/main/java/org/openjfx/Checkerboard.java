package org.openjfx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Checkerboard extends Canvas {
    private static final double CHECKER_BOARD_LINE_WIDTH = 2;
    private static final double ONE_TILE_WIDTH = 40;
    private static final double ONE_TILE_HEIGHT = 40;
    private static final int ROWS = 8;
    private static final int COLUMNS = 8;
    private static final double CHECKER_WIDTH = (COLUMNS  * ONE_TILE_WIDTH) + CHECKER_BOARD_LINE_WIDTH;
    private static final double CHECKER_HEIGHT = (ROWS  * ONE_TILE_HEIGHT) + CHECKER_BOARD_LINE_WIDTH;

    private static final double WIDTH = CHECKER_WIDTH + 10;
    private static final double HEIGHT = CHECKER_HEIGHT + 10;




    public Checkerboard() {
        super(WIDTH, HEIGHT);
    }

    public void drawBoard() {
        GraphicsContext graphicsContext = getGraphicsContext2D();
        graphicsContext.setStroke(Color.GREEN);
        graphicsContext.setLineWidth(CHECKER_BOARD_LINE_WIDTH);
        graphicsContext.strokeRect(1, 1, CHECKER_WIDTH, CHECKER_HEIGHT );

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if ( row % 2 == col % 2 ) {
                    graphicsContext.setFill(Color.LIGHTGRAY);
                }
                else {
                    graphicsContext.setFill(Color.GRAY);
                }
                graphicsContext.fillRect(2 + col*ONE_TILE_WIDTH, 2 + row*ONE_TILE_HEIGHT, ONE_TILE_WIDTH, ONE_TILE_HEIGHT);
            }
        }
    }
}

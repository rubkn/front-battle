package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field{

    public static final int cellSize = 30;
    public static final int PADDING = 10;
    private Rectangle field;
    private int cols;
    private int rows;


    public Field(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {
        field = new Rectangle(PADDING,  PADDING, cols*cellSize, rows*cellSize);
        field.setColor(Color.LIGHT_GRAY);
        field.fill();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return field.getWidth();
    }

    public int getHeight() {
        return field.getHeight();
    }

    public int getX() {
        return field.getX();
    }

    public int getY() {
        return field.getY();
    }

    public int getCellSize() {
        return cellSize;
    }

    public int rowToY(int row) {
        return PADDING + (row * cellSize);
    }

    public int columnToX(int column) {
        return PADDING + (column * cellSize);
    }
}

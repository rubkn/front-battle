package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field{

    public static final int cellSize = 10;
    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private Picture fieldPicture;

    public Field(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {
        fieldPicture = new Picture(PADDING, PADDING, "img/field.png");
        fieldPicture.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return fieldPicture.getWidth();
    }

    public int getHeight() {
        return fieldPicture.getHeight();
    }

    public int rowToY(int row) {
        return (row * cellSize) + PADDING;
    }

    public int columnToX(int column) {
        return (column * cellSize) + PADDING;
    }
}

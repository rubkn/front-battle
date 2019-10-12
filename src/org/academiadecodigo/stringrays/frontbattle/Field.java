package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field{

    public static final int cellSize = 50;
    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private Picture fieldPicture;


    public Field(){
        fieldPicture = new Picture(PADDING, PADDING, "img/field.png");
        fieldPicture.draw();
    }

    public void init() {
        fieldPicture = new Picture(PADDING, PADDING, "img/field.png");
        fieldPicture.draw();
    }

    public int getCols() {
        return cols*cellSize;
    }

    public int getRows() {
        return rows*cellSize;
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

    public int getX() {
        return fieldPicture.getX();
    }

    public int getY() {
        return fieldPicture.getY();
    }

}

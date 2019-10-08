package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.graphics.*;

public class Position {

    private int col;
    private int row;
    private Field field;
    private Rectangle rectangle;

    public Position(int col, int row, Field field) {
        this.col = col;
        this.row = row;
        this.field = field;
        rectangle = new Rectangle(field.columnToX(col),field.rowToY(row),field.getCellSize(), field.getCellSize());
        rectangle.setColor(Color.RED);
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void show() {
        rectangle.fill();
    }

    public void hide() {
        rectangle.delete();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void moveUp() {
        rectangle.translate(0, -1*Field.cellSize);
    }

    public void moveDown() {
        rectangle.translate(0, Field.cellSize);

    }

    public void moveLeft() {
        rectangle.translate(-1*Field.cellSize, 0);

    }

    public void moveRight() {
        rectangle.translate(Field.cellSize, 0);

    }
}

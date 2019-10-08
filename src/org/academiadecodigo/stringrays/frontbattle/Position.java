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
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void show() {
        rectangle.fill();
    }

    public void setColor(Color color) {
        rectangle.setColor(color);
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
        if(rectangle.getY() > field.getY()) {
            rectangle.translate(0, -1);
        }
    }

    public void moveDown() {
        if(rectangle.getY() + rectangle.getHeight() < field.getHeight() + Field.PADDING) {
            rectangle.translate(0, 1);
        }
    }

    public void moveLeft() {
        if(rectangle.getX() > field.getX()) {
            rectangle.translate(-1, 0);
        }

    }

    public void moveRight() {
        if(rectangle.getX() + rectangle.getWidth() < field.getWidth() + Field.PADDING) {
            rectangle.translate(1, 0);
        }

    }
}

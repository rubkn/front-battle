package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Movables.Bullet;

import java.io.PipedOutputStream;

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

    public Rectangle getRectangle() {
        return rectangle;
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
        //if(rectangle.getY() > field.getY()) {
        if (row > 0) {
            row--;
            rectangle.translate(0, -1*Field.cellSize);
        }
    }

    public void moveDown() {
        //if(rectangle.getY() + rectangle.getHeight() < field.getHeight() + Field.PADDING) {
        if (row < field.getRows() - 1) {
            row++;
            rectangle.translate(0, 1*Field.cellSize);
        }
    }

    public void moveLeft() {
       // if(rectangle.getX() > field.getX()) {
        if (col > 0) {
            col--;
            rectangle.translate(-1*Field.cellSize, 0);
        }

    }

    public void moveRight() {
        //if(rectangle.getX() + rectangle.getWidth() < field.getWidth() + Field.PADDING) {
        if (col < field.getCols() - 1) {
            col++;
            rectangle.translate(1*Field.cellSize, 0);

        }

    }

    public boolean equals(Position position) {
        return this.col == position.getCol() && this.row == position.getRow() ? true : false;
    }
}

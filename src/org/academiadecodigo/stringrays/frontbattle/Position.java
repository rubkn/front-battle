package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private int x;
    private int y;
    private Field field;
    private Picture picture;
    private Rectangle rectangle;

    public Position(int x, int y, Field field, String path) {
        this.x = x;
        this.y = y;
        this.field = field;
        picture = new Picture(field.getX(),field.getY(), path);
        rectangle = new Rectangle(picture.getX(), picture.getY(), picture.getWidth(), picture.getHeight());
        rectangle.draw();
    }

    public void show() {
        picture.draw();
    }

    public void hide() {
        picture.delete();
    }

    /*public int getCol() {
        return col;
    }*/

    /*public int getRow() {
        return row;
    }*/

    public void moveUp() {
        if (picture.getY() > 0) {
            //row--;
            picture.translate(0, -5);
            rectangle.translate(0, -5);
        }
    }

    public void moveDown() {
        if (picture.getY() < field.getHeight() - 1) {
            //row++;
            //picture.translate(0, Field.cellSize);
            picture.translate(0, 5);
            rectangle.translate(0, 5);
        }
    }

    public void moveLeft() {
        if (picture.getX() > 0) {
            //col--;
            picture.translate(5, 0);
            rectangle.translate(5 , 0);
        }

    }

    public void moveRight() {
        if (picture.getMaxX() < field.getWidth() - 1) {
            //col++;
            picture.translate(5, 0);
            rectangle.translate(5 , 0);

        }

    }

    public int getX () {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public int getMaxX () {
        return rectangle.getX() + rectangle.getWidth();
    }

    public int getMaxY () {
        return rectangle.getY() + rectangle.getHeight();
    }

    public boolean equals(Position position) {
        return this.x == position.getX() && this.y == position.getY();
    }
}

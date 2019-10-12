package org.academiadecodigo.stringrays.frontbattle;

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
        picture = new Picture(x, y, path);
        rectangle = new Rectangle(picture.getX(), picture.getY(), picture.getWidth(), picture.getHeight());
        rectangle.draw();
    }

    public void show() {
        picture.draw();
    }

    public void hide() {
        picture.delete();
    }

    public void moveUp() {
        if (picture.getY() > Field.PADDING) {
            picture.translate(0, -1);
            rectangle.translate(0, -1);
        }
    }

    public void moveDown() {
        if (picture.getMaxY() < field.getHeight() + Field.PADDING) {
            picture.translate(0, 1);
            rectangle.translate(0, 1);
        }
    }

    public void moveLeft() {
        if (picture.getX() > Field.PADDING) {
            picture.translate(-1, 0);
            rectangle.translate(-1, 0);
        }
    }

    public void moveRight() {
        if (picture.getMaxX() < field.getWidth() + Field.PADDING) {
            picture.translate(1, 0);
            rectangle.translate(1, 0);
        }
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public int getMaxX() {
        return picture.getMaxX();
    }

    public int getMaxY() {
        return rectangle.getY() + rectangle.getHeight();
    }

    public boolean equals(Position position) {
        return this.x == position.getX() && this.y == position.getY();
    }
}

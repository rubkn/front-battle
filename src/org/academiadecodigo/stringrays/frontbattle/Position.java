package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private int col;
    private int row;
    private Field field;
    private Picture picture;

    public Position(int col, int row, Field field, String path) {
        this.col = col;
        this.row = row;
        this.field = field;
        picture = new Picture(field.columnToX(col),field.rowToY(row), path);

    }

    public void show() {
        picture.draw();
    }

    public void hide() {
        picture.delete();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void moveUp() {
        if (row > 0) {
            row--;
            picture.translate(0, -1*Field.cellSize);
        }
    }

    public void moveDown() {
        if (row < field.getRows() - 1) {
            row++;
            picture.translate(0, Field.cellSize);
        }
    }

    public void moveLeft() {
        if (col > 0) {
            col--;
            picture.translate(-1*Field.cellSize, 0);
        }

    }

    public void moveRight() {
        if (col < field.getCols() - 1) {
            col++;
            picture.translate(Field.cellSize, 0);

        }

    }

    public boolean equals(Position position) {
        return this.col == position.getCol() && this.row == position.getRow();
    }
}

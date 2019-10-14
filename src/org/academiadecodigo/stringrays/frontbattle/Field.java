package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field{

    public static final int PADDING = 10;
    private Picture fieldPicture;

    public Field(){
        fieldPicture = new Picture(PADDING, PADDING, "resources/img/field/field-bg.jpg");
        fieldPicture.draw();
    }

    public int getWidth() {
        return fieldPicture.getWidth();
    }

    public int getHeight() {
        return fieldPicture.getHeight();
    }

    public int getX() {
        return fieldPicture.getX();
    }

    public int getY() {
        return fieldPicture.getY();
    }
}

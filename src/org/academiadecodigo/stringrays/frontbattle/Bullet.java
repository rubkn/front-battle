package org.academiadecodigo.stringrays.frontbattle;

public class Bullet {

    private Position position;
    private int bulletDamage;
    private boolean isFired;
    private Direction direction;

    //bullet is instantiated with the last direction the player was facing
    public Bullet(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        bulletDamage = 10;
    }

    //sets bullet to move in the direction given by the player
    public void move() {

        switch (direction) {
            case UP:
                position.moveUp();
                break;
            case DOWN:
                position.moveDown();
                break;
            case LEFT:
                position.moveLeft();
                break;
            case RIGHT:
                position.moveRight();
                break;
        }
    }

    //hides or shows bullet
    public void setFired(boolean fired) {
        if(!fired) {
            isFired = false;
            position.hide();
            return;
        }
        isFired = true;
        position.show();
    }

    public Position getPosition() {
        return position;
    }

    public int getBulletDamage() {
        return bulletDamage;
    }

    public boolean isFired() {
        return isFired;
    }
}
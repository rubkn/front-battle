package org.academiadecodigo.stringrays.frontbattle;

public class Bullet {

    private final int distance = 2;
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
                position.moveUp(distance);
                break;
            case DOWN:
                position.moveDown(distance);
                break;
            case LEFT:
                position.moveLeft(distance);
                break;
            case RIGHT:
                position.moveRight(distance);
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

    public Direction getDirection() {
        return direction;
    }
}
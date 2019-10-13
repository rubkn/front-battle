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
        //TODO CHECK BULLET DAMAGE VALUE
    }

    //sets bullet to move in the direction given by the player
    public void move() {

        switch (direction) {
            case UP:
                position.moveUp(2);
                break;
            case DOWN:
                position.moveDown(2);
                break;
            case LEFT:
                position.moveLeft(2);
                break;
            case RIGHT:
                position.moveRight(2);
                break;
            case UPLEFT:
                position.moveUpLeft(2);
                break;
            case UPRIGHT:
                position.moveUpRight(2);
                break;
            case DOWNLEFT:
                position.moveDownLeft(2);
                break;
            case DOWNRIGHT:
                position.moveDownRight(2);
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
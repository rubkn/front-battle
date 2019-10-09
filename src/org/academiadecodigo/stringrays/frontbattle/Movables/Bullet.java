package org.academiadecodigo.stringrays.frontbattle.Movables;

import org.academiadecodigo.stringrays.frontbattle.Position;

public class Bullet {

    private Position position;
    private int bulletDamage;
    private boolean isFired;
    private Direction direction;

    public Bullet(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        bulletDamage = 10;
    }

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

    public Position getPosition() {
        return position;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        if(!fired) {
            position.hide();
        }
        if (fired) {
            //TODO: PLAYER NEEDS TO SET POSITION TO WHERE HE IS SHOOTING
            position.show();
            /*while (fired) {
                position.moveRight();
            }*/
        }
        isFired = fired;
    }

    public int getBulletDamage() {
        return bulletDamage;
    }
}
package org.academiadecodigo.stringrays.frontbattle.Movables;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Field;
import org.academiadecodigo.stringrays.frontbattle.Position;

public class Player implements Movables {

    private Position position;
    private String name;
    private int health = 100;
    private boolean destroyed;
    //private Bullet[] bullets;

    public Player(String name, Position position, Color color) {
        this.name = name;
        this.position = position;
        position.setColor(color);
    }

    public Position getPosition() {
        return position;
    }

    public Position getPosition() {
        return position;
    }

    public void attack() {

    }

    @Override
    public void move(Direction direction) {

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

    public void hit(int damage) {
        health -= damage;
    }

    public boolean isDestroyed() {
        return false;
    }
}

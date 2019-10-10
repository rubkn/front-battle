package org.academiadecodigo.stringrays.frontbattle.Movables;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Field;
import org.academiadecodigo.stringrays.frontbattle.Position;

public class Player implements Movables {

    private Position position;
    private String name;
    private int health = 100;
    private boolean destroyed;
    private Field field;
    private Direction direction;

    public Player(String name, Position position, Color color, Field field, Direction direction) {
        this.name = name;
        this.position = position;
        position.setColor(color);
        this.field = field;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Bullet attack() {
        if (health > 0) {
            switch (direction) {
                case UP:
                    if (position.getRow() != 0) {
                        return new Bullet(new Position(position.getCol(), position.getRow() - 1, field), direction);
                    }
                case DOWN:
                    if (position.getRow() != field.getRows() - 1) {
                        return new Bullet(new Position(position.getCol(), position.getRow() + 1, field), direction);
                    }
                case LEFT:
                    if (position.getCol() != 0) {
                        return new Bullet(new Position(position.getCol() - 1, position.getRow(), field), direction);
                    }
                case RIGHT:
                    if (position.getCol() != field.getRows() - 1) {
                    return new Bullet(new Position(position.getCol() + 1, position.getRow(), field), direction);
                }
            }
        }
        return null;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
        //position.hide();
        //position.show();
        if (health <= 0) position.hide();
        destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}

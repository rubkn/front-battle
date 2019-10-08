package org.academiadecodigo.stringrays.frontbattle.Movables;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Field;
import org.academiadecodigo.stringrays.frontbattle.Position;

public class Player implements Movables{

    private Position position;
    private String name;
    private int health;
    private boolean destroyed;
    private Bullet[] bullets;

    public Player(String name, Position position, Color color) {
        this.name = name;
        health = 100;
        Rectangle player = new Rectangle(position.getCol(), position.getRow(), Field.cellSize, Field.cellSize);
        player.setColor(color);
        player.fill();
        bullets = new Bullet[100];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
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

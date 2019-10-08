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
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    public void hit(int damage) {
        health -= damage;
    }

    public boolean isDestroyed() {
        return false;
    }
}

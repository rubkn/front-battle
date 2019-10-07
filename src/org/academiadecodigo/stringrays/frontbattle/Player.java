package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.graphics.*;

public class Player {

    private Position position;
    private String name;
    private int health;
    private boolean destroyed;
    private Bullet[] bullets;

    public Player(String name, Position position, Color color) {
        this.name = name;
        health = 100;
        Rectangle player = new Rectangle(position.getX(), position.getY(), 30, 30);
        player.setColor(color);
        player.fill();
        bullets = new Bullet[100];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
    }

    public void attack() {
        //set bullet position & translate
        //set bullet move to true
    }

    public void move() {
        //player set pos
    }

    public void hit(int damage) {
        health -= damage;
    }

    public boolean isDestroyed() {
        return false;
    }
}

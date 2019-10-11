package org.academiadecodigo.stringrays.frontbattle.Movables;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.stringrays.frontbattle.Field;
import org.academiadecodigo.stringrays.frontbattle.Position;

public class Player implements Movables {

    private Position position;
    private String name;
    private int health = 100;
    private boolean destroyed;
    private Field field;
    private Direction direction;
    private Picture healthPicture;
    private Picture playerPicture;

    public Player(String name, Position position, Color color, Field field, Direction direction, Picture healthPicture) {
        this.name = name;
        this.position = position;
        //position.setColor(color);
        this.field = field;
        this.direction = direction;
        this.healthPicture = healthPicture;
        healthPicture.draw();
    }

    public Position getPosition() {
        return position;
    }

    public Bullet attack() throws Exception {
        if (health > 0) {
            return new Bullet(new Position(position.getCol(), position.getRow(), field, "img/bullet.png"), direction);
        }
        throw new Exception();
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

        switch (health) {
            case 90:
                healthPicture.load("img/90health.png");
                break;
            case 80:
                healthPicture.load("img/80health.png");
                break;
            case 70:
                healthPicture.load("img/70health.png");
                break;
            case 60:
                healthPicture.load("img/60health.png");
                break;
            case 50:
                healthPicture.load("img/50health.png");
                break;
            case 40:
                healthPicture.load("img/40health.png");
                break;
            case 30:
                healthPicture.load("img/30health.png");
                break;
            case 20:
                healthPicture.load("img/20health.png");
                break;
            case 10:
                healthPicture.load("img/10health.png");
                break;
            case 0:
                healthPicture.delete();
        }
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

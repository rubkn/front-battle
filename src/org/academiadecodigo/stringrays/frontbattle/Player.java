package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Movables {

    private Position position;
    private String name;
    private int health = 100;
    private boolean destroyed;
    private Field field;
    private Direction direction;
    private Picture healthPicture;
    private Collision collision;

    public Player(String name, Position position, Field field, Direction direction, Picture healthPicture) {
        this.name = name;
        this.position = position;
        this.field = field;
        this.direction = direction;
        this.healthPicture = healthPicture;
        healthPicture.draw();
    }

    public Position getPosition() {
        return position;
    }

    public Bullet attack() {

        if (health > 0) {

            switch (direction) {
                case UP:
                    if (this.position.getY() > 0) {
                        return new Bullet(new Position(position.getX(), position.getY() - 1, field, "img/bullet.png"), direction);
                    }
                case DOWN:
                    if (this.position.getY() < field.getRows() - 1) {
                        return new Bullet(new Position(position.getX(), position.getY() + 1, field, "img/bullet.png"), direction);
                    }
                case LEFT:
                    if (this.position.getX() > 0) {
                        return new Bullet(new Position(position.getX() - 1, position.getY(), field, "img/bullet.png"), direction);
                    }
                case RIGHT:
                    if (this.position.getX() < field.getRows() - 1) {
                        return new Bullet(new Position(position.getX() + 1, position.getY(), field, "img/bullet.png"), direction);
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
        if (health <= 0) {
            position.hide();
            destroyed = true;
            GameOver.gameOver(field);
        }
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

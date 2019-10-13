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

        //TODO REMOVE THIS CONDITION IF THE GAME OVER IS WELL DONE
        if (health > 0) {

            //TODO GET THE BULLET SIZE FIXED AND SHOOT RIGHT WITHOUT EXPANDING CANVAS
            switch (direction) {
                case UP:
                    return new Bullet(new Position((position.getX() + position.getMaxX()) / 2, position.getY() - 20, field, "img/bullet/upbullet1.png", 2), direction);
                case DOWN:
                    return new Bullet(new Position((position.getX() + position.getMaxX()) / 2, position.getMaxY(), field, "img/bullet/downbullet1.png", 2), direction);
                case LEFT:
                    return new Bullet(new Position(position.getX() - 20, (position.getY() + position.getMaxY()) / 2, field, "img/bullet/leftbullet1.png", 2), direction);
                case RIGHT:
                    if (this.position.getMaxX() < field.getWidth() - 10) {
                        return new Bullet(new Position(position.getMaxX(), (position.getY() + position.getMaxY()) / 2, field, "img/bullet/rightbullet1.png", 2), direction);
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
                healthPicture.load("img/health/90health.png");
                break;
            case 80:
                healthPicture.load("img/health/80health.png");
                break;
            case 70:
                healthPicture.load("img/health/70health.png");
                break;
            case 60:
                healthPicture.load("img/health/60health.png");
                break;
            case 50:
                healthPicture.load("img/health/50health.png");
                break;
            case 40:
                healthPicture.load("img/health/40health.png");
                break;
            case 30:
                healthPicture.load("img/health/30health.png");
                break;
            case 20:
                healthPicture.load("img/health/20health.png");
                break;
            case 10:
                healthPicture.load("img/health/10health.png");
                break;
            case 0:
                healthPicture.delete();
        }
        //position.hide();
        //position.show();
        if (health <= 0) {
            position.hide();
            destroyed = true;
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

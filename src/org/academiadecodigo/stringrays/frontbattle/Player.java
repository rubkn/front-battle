package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Movables {

    private Position position;
    private int health = 100;
    private Field field;
    private Direction direction;
    private Picture healthPicture;
    private Direction oldDirection;
    private String picturePath;
    private Sound sound;

    public Player(Position position, Field field, Direction direction, Picture healthPicture, String picturePath) {
        this.position = position;
        this.field = field;
        this.direction = direction;
        this.oldDirection = direction;
        this.healthPicture = healthPicture;
        this.picturePath = picturePath;
        healthPicture.draw();
    }

    public Position getPosition() {
        return position;
    }

    public Bullet attack() {

            //TODO: SHOOT DOWN AND RIGHT, AT THE BORDERS, WITHOUT EXPANDING CANVAS
            switch (direction) {
                case UP:
                    return new Bullet(new Position((position.getX() + position.getMaxX()) / 2, position.getY() - 20, field, "resources/img/bullet/upbullet1.png"), direction);
                case DOWN:
                    return new Bullet(new Position((position.getX() + position.getMaxX()) / 2, position.getMaxY(), field, "resources/img/bullet/downbullet1.png"), direction);
                case LEFT:
                    return new Bullet(new Position(position.getX() - 20, (position.getY() + position.getMaxY()) / 2, field, "resources/img/bullet/leftbullet1.png"), direction);
                case RIGHT:
                    return new Bullet(new Position(position.getMaxX(), (position.getY() + position.getMaxY()) / 2, field, "resources/img/bullet/rightbullet1.png"), direction);
                case UPLEFT:
                    return new Bullet(new Position(position.getX() - 20, position.getY(), field, "resources/img/bullet/upbullet1.png"), direction);
                case UPRIGHT:
                    return new Bullet(new Position(position.getMaxX() + 20, position.getY(), field, "resources/img/bullet/upbullet1.png"), direction);
                case DOWNLEFT:
                    return new Bullet(new Position(position.getX(), position.getMaxY(), field, "resources/img/bullet/downbullet1.png"), direction);
                case DOWNRIGHT:
                    return new Bullet(new Position(position.getMaxX(), position.getMaxY(), field, "resources/img/bullet/downbullet1.png"), direction);
            }
        return null;
    }

    public void setDirection(Direction direction) {

        this.direction = direction;

        if (direction != oldDirection) {
            switch (direction) {
                case UP:
                    position.getPicture().load(picturePath + "back/back1.png");
                    oldDirection = direction;
                    break;
                case DOWN:
                    position.getPicture().load(picturePath + "front/front1.png");
                    oldDirection = direction;
                    break;
                case LEFT:
                    position.getPicture().load(picturePath + "left/left1.png");
                    oldDirection = direction;
                    break;
                case RIGHT:
                    position.getPicture().load(picturePath + "right/right1.png");
                    oldDirection = direction;
                    break;
                case UPLEFT:
                    position.getPicture().load(picturePath + "back/back1.png");
                    oldDirection = direction;
                    break;
                case UPRIGHT:
                    position.getPicture().load(picturePath + "back/back1.png");
                    oldDirection = direction;
                    break;
                case DOWNLEFT:
                    position.getPicture().load(picturePath + "front/front1.png");
                    oldDirection = direction;
                    break;
                case DOWNRIGHT:
                    position.getPicture().load(picturePath + "front/front1.png");
                    oldDirection = direction;
                    break;
            }
        }
    }

    @Override
    public void move(Direction direction, int distance) {

        switch (direction) {
            case UP:
                position.moveUp(distance);
                break;
            case DOWN:
                position.moveDown(distance);
                break;
            case LEFT:
                position.moveLeft(distance);
                break;
            case RIGHT:
                position.moveRight(distance);
                break;
            case UPLEFT:
                position.moveUpLeft(distance);
                break;
            case UPRIGHT:
                position.moveUpRight(distance);
                break;
            case DOWNLEFT:
                position.moveDownLeft(distance);
                break;
            case DOWNRIGHT:
                position.moveDownRight(distance);
                break;
        }
    }

    public void hit(int damage) {
        health -= damage;

        switch (health) {
            case 90:
                healthPicture.load("resources/img/health/90health.png");
                break;
            case 80:
                healthPicture.load("resources/img/health/80health.png");
                break;
            case 70:
                healthPicture.load("resources/img/health/70health.png");
                break;
            case 60:
                healthPicture.load("resources/img/health/60health.png");
                break;
            case 50:
                healthPicture.load("resources/img/health/50health.png");
                break;
            case 40:
                healthPicture.load("resources/img/health/40health.png");
                break;
            case 30:
                healthPicture.load("resources/img/health/30health.png");
                break;
            case 20:
                healthPicture.load("resources/img/health/20health.png");
                break;
            case 10:
                healthPicture.load("resources/img/health/10health.png");
                break;
            case 0:
                healthPicture.delete();
        }

        if (health <= 0) {
            position.hide();
        }
    }

    public int getHealth() {
        return health;
    }
}

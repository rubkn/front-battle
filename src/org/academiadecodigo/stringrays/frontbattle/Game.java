package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private final int distance = 1;
    private Player player1;
    private Player player2;
    private Field field;
    private boolean wKey, aKey, sKey, dKey, spaceKey, upKey, leftKey, downKey, rightKey, pKey;
    private Keyboard keyboard = new Keyboard(this);
    private int bulletCounter;
    private int delay = 30;
    private Bullet[] bullets;
    private Collision collision;

    public void creation() {
        field = new Field();

        //instantiate players with name, initial position, image, initial direction and health score board
        player1 = new Player("Player One",
                new Position(field.getX() + Field.PADDING, field.getHeight() / 2, field, "img/player50.png"), field, Direction.RIGHT,
                new Picture(field.getX(), field.getHeight() + 20, "img/100health.png"));

        player2 = new Player("Player Two",
                new Position(field.getWidth() - 50, field.getHeight() / 2, field, "img/player50.png"), field, Direction.LEFT,
                new Picture(field.getWidth() - 80, field.getHeight() + 20, "img/100health.png"));

        player1.getPosition().show();
        player2.getPosition().show();
        collision = new Collision();

        //bullet array for both players to use
        bullets = new Bullet[100];
    }

    public void gameStart() throws InterruptedException {

        keyboardKeys();

        //game engine
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            Thread.sleep(3);
            if (delay == 30) {
                createBullets();
                delay = 0;
            }
            moveBullets();
            collision.checkBulletBounds(bullets, field);
            movePlayers();
            delay++;
            //TODO CHANGE BULLET DELAY
        }
        GameOver.gameOver(field, player1, player2);
    }


    public void addKeyboardEvent(int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }

    public void keyboardKeys() {
        addKeyboardEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_W, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_W, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_S, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_A, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_A, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_D, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_D, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_P, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_P, KeyboardEventType.KEY_RELEASED);

    }

    public void movePlayers() {

        //all the keys to move the players but they only move if they're not trying to go against the other player
        //needs to checkBulletHits() after every movement!

        if (upKey) {
            if (!collision.movableCollisions(player2, player1, Direction.UP)) {
                player2.getPosition().moveUp(distance);
            }

        }
        if (downKey) {
            if (!collision.movableCollisions(player2, player1, Direction.DOWN)) {
                player2.getPosition().moveDown(distance);
            }
        }
        if (rightKey) {
            if (!collision.movableCollisions(player2, player1, Direction.RIGHT)) {
                player2.getPosition().moveRight(distance);
            }
        }
        if (leftKey) {
            if (!collision.movableCollisions(player2, player1, Direction.LEFT)) {
                player2.getPosition().moveLeft(distance);
            }
        }
        if (wKey) {
            if (!collision.movableCollisions(player1, player2, Direction.UP)) {
                player1.getPosition().moveUp(distance);
            }
        }
        if (sKey) {
            if (!collision.movableCollisions(player1, player2, Direction.DOWN)) {
                player1.getPosition().moveDown(distance);
            }
        }
        if (aKey) {
            if (!collision.movableCollisions(player1, player2, Direction.LEFT)) {
                player1.getPosition().moveLeft(distance);
            }
        }
        if (dKey) {
            if (!collision.movableCollisions(player1, player2, Direction.RIGHT)) {
                player1.getPosition().moveRight(distance);
            }
        }

        //needs to checkBulletHits() after every movement!
        collision.checkBulletHits(player1, player2, bullets);
    }

    //TODO BEST METHOD FOR PLAYER MOVEMENT
    /*
    public void movePlayer(Player player, Direction direction) {

        Player otherPlayer = player2;

        if (player == player2) {
            otherPlayer = player1;
        }

        switch (direction) {
            case UP:
                if (player.getPosition().getCol() != otherPlayer.getPosition().getCol() ||
                        player.getPosition().getRow() != otherPlayer.getPosition().getRow() + 1) {
                    player.getPosition().moveUp();
                }
                break;
            case DOWN:
                if (player.getPosition().getCol() != otherPlayer.getPosition().getCol() ||
                        player.getPosition().getRow() != otherPlayer.getPosition().getRow() - 1) {
                    player.getPosition().moveDown();
                }
                break;
            case LEFT:
                if (player.getPosition().getCol() != otherPlayer.getPosition().getCol() + 1 ||
                        player.getPosition().getRow() != otherPlayer.getPosition().getRow()) {
                    player.getPosition().moveLeft();
                }
                break;
            case RIGHT:
                if (player.getPosition().getCol() != otherPlayer.getPosition().getCol() - 1 ||
                        player.getPosition().getRow() != otherPlayer.getPosition().getRow()) {
                    player.getPosition().moveRight();
                }
                break;
        }
    }
    */

    public void createBullets() {

        //the key for the players to shoot bullets

        if (spaceKey) {
            shootBullet(player1);
        }

        if (pKey) {
            shootBullet(player2);
        }
    }

    public void shootBullet(Player player) {

        //method for returning a new bullet if the player presses the shoot key

        Bullet newBullet = player.attack();
        if (newBullet != null) {
            bullets[bulletCounter] = newBullet;
            bullets[bulletCounter].setFired(true);
            bulletCounter++;
        }
    }

    public void moveBullets() {

        //method to move bullets every game cycle and check for bullet hits

        for (Bullet bullet : bullets) {
            if (bullet == null) {
                continue;
            }
            if (bullet.isFired()) {
                bullet.move();
            }
        }
        collision.checkBulletHits(player1, player2, bullets);
        if (bulletCounter >= 99) {
            bulletCounter = 0;
        }
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case (KeyboardEvent.KEY_W):
                player1.setDirection(Direction.UP);
                wKey = true;
                break;
            case (KeyboardEvent.KEY_A):
                player1.setDirection(Direction.LEFT);
                aKey = true;
                break;
            case (KeyboardEvent.KEY_S):
                player1.setDirection(Direction.DOWN);
                sKey = true;
                break;
            case (KeyboardEvent.KEY_D):
                player1.setDirection(Direction.RIGHT);
                dKey = true;
                break;
            case (KeyboardEvent.KEY_SPACE):
                spaceKey = true;
                break;
            case (KeyboardEvent.KEY_UP):
                player2.setDirection(Direction.UP);
                upKey = true;
                break;
            case (KeyboardEvent.KEY_LEFT):
                player2.setDirection(Direction.LEFT);
                leftKey = true;
                break;
            case (KeyboardEvent.KEY_DOWN):
                player2.setDirection(Direction.DOWN);
                downKey = true;
                break;
            case (KeyboardEvent.KEY_RIGHT):
                player2.setDirection(Direction.RIGHT);
                rightKey = true;
                break;
            case (KeyboardEvent.KEY_P):
                pKey = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        switch (e.getKey()) {
            case (KeyboardEvent.KEY_W):
                wKey = false;
                break;
            case (KeyboardEvent.KEY_A):
                aKey = false;
                break;
            case (KeyboardEvent.KEY_S):
                sKey = false;
                break;
            case (KeyboardEvent.KEY_D):
                dKey = false;
                break;
            case KeyboardEvent.KEY_SPACE:
                spaceKey = false;
                break;
            case (KeyboardEvent.KEY_UP):
                upKey = false;
                break;
            case (KeyboardEvent.KEY_LEFT):
                leftKey = false;
                break;
            case (KeyboardEvent.KEY_DOWN):
                downKey = false;
                break;
            case (KeyboardEvent.KEY_RIGHT):
                rightKey = false;
                break;
            case (KeyboardEvent.KEY_P):
                pKey = false;
        }
    }
}

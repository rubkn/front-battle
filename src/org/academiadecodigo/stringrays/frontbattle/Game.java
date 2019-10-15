package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Game implements KeyboardHandler {

    private Player player1;
    private Player player2;
    private Field field;
    private boolean wKey, aKey, sKey, dKey, spaceKey, upKey, leftKey, downKey, rightKey, pKey;
    private ArrayList<Boolean> keys = new ArrayList<>(10);
    private Keyboard keyboard = new Keyboard(this);
    private int bulletCounter;
    private Bullet[] bullets;
    private Collision collision;
    private int playerOneDelay = 0;
    private int playerTwoDelay = 0;

    public void creation() {
        field = new Field();

        //instantiate players with name, initial position, image, initial direction and health score board
        player1 = new Player(
                new Position(field.getX() + Field.PADDING, field.getHeight() / 2, field, "resources/img/player1/right/right1.png"), field, Direction.RIGHT,
                new Picture(field.getX() + 10, field.getHeight() - 20, "resources/img/health/fullhealth.png"), "resources/img/player1/");

        player2 = new Player(
                new Position(field.getWidth() - 50, field.getHeight() / 2, field, "resources/img/player2/left/left1.png"), field, Direction.LEFT,
                new Picture(field.getWidth() - 120, field.getHeight() - 20, "resources/img/health/fullhealth.png"), "resources/img/player2/");

        player1.getPosition().show();
        player2.getPosition().show();
        collision = new Collision();

        //bullet array for both players to use
        bullets = new Bullet[100];
    }

    public void gameStart(Menu menu) throws InterruptedException {
        keyboardKeys();


        //game engine
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            Thread.sleep(3);
            createBullets();
            moveBullets();
            collision.checkBulletBounds(bullets, field);
            movePlayers();
        }

        if (player1.getHealth() <= 0) {
            menu.gameOverMenu("resources/img/wins/player2wins.png");
        }
        if (player2.getHealth() <= 0) {
            menu.gameOverMenu("resources/img/wins/player1wins.png");
        }
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

        //player2 move upleft
        if (keys.contains(leftKey) && keys.contains(upKey) &&
                !keys.contains(rightKey) && !keys.contains(downKey)) {
            player2.setDirection(Direction.UPLEFT);
            if (!collision.movableCollisions(player2, player1, Direction.UPLEFT)) {
                player2.getPosition().moveUpLeft(1);
            }
        }

        //player2 move upright
        if (keys.contains(rightKey) && keys.contains(upKey) &&
                !keys.contains(leftKey) && !keys.contains(downKey)) {
            player2.setDirection(Direction.UPRIGHT);
            if (!collision.movableCollisions(player2, player1, Direction.UPRIGHT)) {
                player2.getPosition().moveUpRight(1);
            }
        }

        //player2 move downleft
        if (keys.contains(downKey) && keys.contains(leftKey) &&
                !keys.contains(rightKey) && !keys.contains(upKey)) {
            player2.setDirection(Direction.DOWNLEFT);
            if (!collision.movableCollisions(player2, player1, Direction.DOWNLEFT)) {
                player2.getPosition().moveDownLeft(1);
            }
        }

        //player2 move downright
        if (keys.contains(downKey) && keys.contains(rightKey) &&
                !keys.contains(leftKey) && !keys.contains(upKey)) {
            player2.setDirection(Direction.DOWNRIGHT);
            if (!collision.movableCollisions(player2, player1, Direction.DOWNRIGHT)) {
                player2.getPosition().moveDownRight(1);
            }
        }

        //player2 move up
        if (keys.contains(upKey) && !keys.contains(leftKey) &&
                !keys.contains(rightKey) && !keys.contains(downKey)) {
            player2.setDirection(Direction.UP);
            if (!collision.movableCollisions(player2, player1, Direction.UP)) {
                player2.getPosition().moveUp(1);
            }

        }

        //player2 move down
        if (keys.contains(downKey) && !keys.contains(leftKey)
                && !keys.contains(rightKey) && !keys.contains(upKey)) {
            player2.setDirection(Direction.DOWN);
            if (!collision.movableCollisions(player2, player1, Direction.DOWN)) {
                player2.getPosition().moveDown(1);
            }
        }

        //player2 move right
        if (keys.contains(rightKey) && !keys.contains(leftKey) &&
                !keys.contains(downKey) && !keys.contains(upKey)) {
            player2.setDirection(Direction.RIGHT);
            if (!collision.movableCollisions(player2, player1, Direction.RIGHT)) {
                player2.getPosition().moveRight(1);
            }
        }

        //player2 move left
        if (keys.contains(leftKey) && !keys.contains(upKey) &&
                !keys.contains(rightKey) && !keys.contains(downKey)) {
            player2.setDirection(Direction.LEFT);
            if (!collision.movableCollisions(player2, player1, Direction.LEFT)) {
                player2.getPosition().moveLeft(1);
            }
        }

        //player1 move upleft
        if (keys.contains(wKey) && keys.contains(aKey) &&
                !keys.contains(dKey) && !keys.contains(sKey)) {
            if (!collision.movableCollisions(player1, player2, Direction.UPLEFT)) {
                player1.setDirection(Direction.UPLEFT);
                player1.getPosition().moveUpLeft(1);
            }
        }

        //player1 move upright
        if (keys.contains(wKey) && keys.contains(dKey) &&
                !keys.contains(aKey) && !keys.contains(sKey)) {
            if (!collision.movableCollisions(player1, player2, Direction.UPRIGHT)) {
                player1.setDirection(Direction.UPRIGHT);
                player1.getPosition().moveUpRight(1);
            }
        }

        //player1 move downleft
        if (keys.contains(aKey) && keys.contains(sKey) &&
                !keys.contains(dKey) && !keys.contains(wKey)) {
            if (!collision.movableCollisions(player1, player2, Direction.DOWNLEFT)) {
                player1.setDirection(Direction.DOWNLEFT);
                player1.getPosition().moveDownLeft(1);
            }
        }

        //player1 move downright
        if (keys.contains(sKey) && keys.contains(dKey) &&
                !keys.contains(aKey) && !keys.contains(wKey)) {
            if (!collision.movableCollisions(player1, player2, Direction.DOWNRIGHT)) {
                player1.setDirection(Direction.DOWNRIGHT);
                player1.getPosition().moveDownRight(1);
            }
        }

        //player1 move up
        if (keys.contains(wKey) && !keys.contains(dKey) &&
                !keys.contains(aKey) && !keys.contains(sKey)) {
            if (!collision.movableCollisions(player1, player2, Direction.UP)) {
                player1.setDirection(Direction.UP);
                player1.getPosition().moveUp(1);
            }
        }

        //player1 move down
        if (keys.contains(sKey) && !keys.contains(wKey) &&
                !keys.contains(aKey) && !keys.contains(dKey)) {
            if (!collision.movableCollisions(player1, player2, Direction.DOWN)) {
                player1.setDirection(Direction.DOWN);
                player1.getPosition().moveDown(1);
            }
        }

        //player1 move left
        if (keys.contains(aKey) && !keys.contains(sKey) &&
                !keys.contains(dKey) && !keys.contains(wKey)) {
            if (!collision.movableCollisions(player1, player2, Direction.LEFT)) {
                player1.setDirection(Direction.LEFT);
                player1.getPosition().moveLeft(1);
            }
        }

        //player1 move right
        if (keys.contains(dKey) && !keys.contains(aKey) &&
                !keys.contains(sKey) && !keys.contains(wKey)) {
            if (!collision.movableCollisions(player1, player2, Direction.RIGHT)) {
                player1.setDirection(Direction.RIGHT);
                player1.getPosition().moveRight(1);
            }
        }

        //needs to checkBulletHits() after every movement!
        collision.checkBulletHits(player1, player2, bullets);
    }

    public void createBullets() {

        //if the key the players use to shoot bullets is pressed, use method shootBullet
        if (spaceKey) {
            if (playerOneDelay == 0) {
                shootBullet(player1);
            }
            playerOneDelay++;
        }

        if (pKey) {
            if (playerTwoDelay == 0) {
                shootBullet(player2);
            }
            playerTwoDelay++;
        }

        if (playerOneDelay == 60) {
            playerOneDelay = 0;
        }

        if (playerTwoDelay == 60) {
            playerTwoDelay = 0;
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
                //player1.setDirection(Direction.UP);
                wKey = true;
                keys.add(wKey);
                break;
            case (KeyboardEvent.KEY_A):
                //player1.setDirection(Direction.LEFT);
                aKey = true;
                keys.add(aKey);
                break;
            case (KeyboardEvent.KEY_S):
                //player1.setDirection(Direction.DOWN);
                sKey = true;
                keys.add(sKey);
                break;
            case (KeyboardEvent.KEY_D):
                //player1.setDirection(Direction.RIGHT);
                dKey = true;
                keys.add(dKey);
                break;
            case (KeyboardEvent.KEY_SPACE):
                spaceKey = true;
                //keys.add(spaceKey);
                break;
            case (KeyboardEvent.KEY_UP):
                //player2.setDirection(Direction.UP);
                upKey = true;
                keys.add(upKey);
                break;
            case (KeyboardEvent.KEY_LEFT):
                //player2.setDirection(Direction.LEFT);
                leftKey = true;
                keys.add(leftKey);
                break;
            case (KeyboardEvent.KEY_DOWN):
                //player2.setDirection(Direction.DOWN);
                downKey = true;
                keys.add(downKey);
                break;
            case (KeyboardEvent.KEY_RIGHT):
                //player2.setDirection(Direction.RIGHT);
                rightKey = true;
                keys.add(rightKey);
                break;
            case (KeyboardEvent.KEY_P):
                pKey = true;
                //keys.add(aKey);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        switch (e.getKey()) {
            case (KeyboardEvent.KEY_W):
                wKey = false;
                keys.remove(wKey);
                break;
            case (KeyboardEvent.KEY_A):
                aKey = false;
                keys.remove(aKey);
                break;
            case (KeyboardEvent.KEY_S):
                sKey = false;
                keys.remove(sKey);
                break;
            case (KeyboardEvent.KEY_D):
                dKey = false;
                keys.remove(dKey);
                break;
            case KeyboardEvent.KEY_SPACE:
                spaceKey = false;
                playerOneDelay = 0;
                break;
            case (KeyboardEvent.KEY_UP):
                upKey = false;
                keys.remove(upKey);
                break;
            case (KeyboardEvent.KEY_LEFT):
                leftKey = false;
                keys.remove(leftKey);
                break;
            case (KeyboardEvent.KEY_DOWN):
                downKey = false;
                keys.remove(downKey);
                break;
            case (KeyboardEvent.KEY_RIGHT):
                rightKey = false;
                keys.remove(rightKey);
                break;
            case (KeyboardEvent.KEY_P):
                pKey = false;
                playerTwoDelay = 0;
                break;
        }
    }
}

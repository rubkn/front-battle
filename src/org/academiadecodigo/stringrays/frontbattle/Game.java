package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Movables.Direction;
import org.academiadecodigo.stringrays.frontbattle.Movables.Player;
import org.academiadecodigo.stringrays.frontbattle.Movables.Bullet;

public class Game implements KeyboardHandler {


    private Player player1;
    private Player player2;
    private Field field;
    private boolean wKey, aKey, sKey, dKey, spaceKey, upKey, leftKey, downKey, rightKey, pKey;
    private Keyboard keyboard = new Keyboard(this);
    private Bullet[] bullets;
    private int bulletCounter;

    public void creation() {
        field = new Field(25, 25);
        field.init();
        player1 = new Player("player1", new Position(1, field.getRows() / 2, field), Color.BLUE, field);
        player1.getPosition().show();
        player2 = new Player("player1", new Position(23, field.getRows() / 2, field), Color.RED,field);
        player2.getPosition().show();
        bullets = new Bullet[100];

    }

    public void gameStart() throws InterruptedException {

        keyboardKeys();

        while (true) {
            Thread.sleep(100);
            movePlayers();
            moveBullets();
            //checkCollisions();
        }
    }

    public void checkCollisions() {

        for (int i = 0; i < bullets.length; i++) {

            //if bullet is not fired continue to next bullet
            if (!bullets[i].isFired()) {
                continue;
            }

            //check if bullet is out of range by left or right side of screen
            if (bullets[i].getPosition().getCol() < 0 || bullets[i].getPosition().getCol() > field.getWidth() - Field.cellSize) {
                bullets[i].setFired(false);
            }

            //check if bullet is out of range by top or lower side of screen
            if (bullets[i].getPosition().getRow() < 0 || bullets[i].getPosition().getRow() > field.getHeight()) {
                bullets[i].setFired(false);
            }

            //check if any bullet is hitting player 1
            if (player1.getPosition().equals(bullets[i].getPosition())) {
                player1.hit(bullets[i].getBulletDamage());
                bullets[i].setFired(false);
            }

            //check if any bullet is hitting player 2
            if (player2.getPosition().equals(bullets[i].getPosition())) {
                player2.hit(bullets[i].getBulletDamage());
                bullets[i].setFired(false);
            }

        }
    }

    public void addKeyboardEvent(int key, KeyboardEventType type) throws InterruptedException {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }

    public void keyboardKeys() throws InterruptedException {
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

    }

    public void movePlayers() throws InterruptedException {

        if (upKey) {
            player2.getPosition().moveUp();
        }
        if (downKey) {
            player2.getPosition().moveDown();
        }
        if (rightKey) {
            player2.getPosition().moveRight();
        }
        if (leftKey) {
            player2.getPosition().moveLeft();
        }
        if (wKey) {
            player1.getPosition().moveUp();
        }
        if (sKey) {
            player1.getPosition().moveDown();
        }
        if (aKey) {
            player1.getPosition().moveLeft();
        }
        if (dKey) {
            player1.getPosition().moveRight();
        }
    }

    public void moveBullets() {
        if (spaceKey) {
            bullets[bulletCounter] = player1.attack();
            bullets[bulletCounter].setFired(true);
            bullets[bulletCounter].move(Direction.RIGHT);
            bulletCounter++;
        }
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case (KeyboardEvent.KEY_W):
                wKey = true;
                break;
            case (KeyboardEvent.KEY_A):
                aKey = true;
                break;
            case (KeyboardEvent.KEY_S):
                sKey = true;
                break;
            case (KeyboardEvent.KEY_D):
                dKey = true;
                break;
            case (KeyboardEvent.KEY_SPACE):
                spaceKey = true;
                break;
            case (KeyboardEvent.KEY_UP):
                upKey = true;
                break;
            case (KeyboardEvent.KEY_LEFT):
                leftKey = true;
                break;
            case (KeyboardEvent.KEY_DOWN):
                downKey = true;
                break;
            case (KeyboardEvent.KEY_RIGHT):
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
        }

    }
}

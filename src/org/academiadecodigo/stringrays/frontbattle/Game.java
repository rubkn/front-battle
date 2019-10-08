package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Movables.Direction;
import org.academiadecodigo.stringrays.frontbattle.Movables.Player;

public class Game implements KeyboardHandler {


    private Player player1;
    private Player player2;
    private int padding = 10;
    private Field field;
    private boolean wKey, aKey, sKey, dKey, spaceKey, upKey, leftKey, downKey, rightKey, pKey;
    private Keyboard keyboard = new Keyboard(this);

    public void creation() {
        field = new Field(25, 25);
        field.init();
        player1 = new Player("player1", new Position( 1,field.getRows()/2, field), Color.BLUE);
        player2 = new Player("player1", new Position( 24,field.getRows()/2, field), Color.RED);
    }

    public void gameStart() throws InterruptedException {

        keyboardKeys();

        while (true) {
            Thread.sleep(3);
            moveAll();
        }
    }

    public void collide() {
        //verify if pos equals pos
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

    }


    public void moveAll() throws InterruptedException {

        if (upKey) {
            player1.getPosition().moveUp();
        }
        if (downKey) {
            player1.getPosition().moveDown();
        }
        if (rightKey) {
            player1.getPosition().moveRight();
        }
        if (leftKey) {
            player1.getPosition().moveLeft();
        }
        if (wKey) {
            player2.getPosition().moveUp();
        }
        if (sKey) {
            player2.getPosition().moveDown();
        }
        if (aKey) {
            player2.getPosition().moveLeft();
        }
        if (dKey) {
            player2.getPosition().moveRight();
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

package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Movables.Player;

public class Game implements KeyboardHandler {


    private Player player1;
    private Player player2;
    private int padding = 10;
    private Field field;
    private boolean wKey, aKey, sKey, dKey, spaceKey, upKey, leftKey, downKey, rightKey, pKey;

    public void creation() {
        field = new Field(25,25);
        field.init();
        player1 = new Player("player1", new Position(field.getX() + Field.PADDING,field.getHeight()/2), Color.ORANGE);
        player2 = new Player("player2", new Position(field.getWidth() - field.getCellSize(), field.getHeight()/2), Color.RED);
    }

    public void gameStart() {

    }

    public void collide() {
        //verify if pos equals pos
    }

    public void moveAll() {
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

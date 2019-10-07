package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.*;

public class Game implements KeyboardHandler {


    private Player player1;
    private Player player2;
    private Rectangle border;
    private int padding = 10;
    private Rectangle field;
    private boolean wKey, aKey, sKey, dKey, spaceKey, upKey, leftKey, downKey, rightKey, pKey;

    public void creation() {
        border = new Rectangle(padding, padding, 1000, 800);
        border.fill();
        field = new Rectangle(padding + 10, padding + 10, 980, 780);
        field.setColor(Color.LIGHT_GRAY);
        field.fill();
        player1 = new Player("Player1", new Position(field.getX() + padding, field.getHeight() / 2), Color.BLUE);
        player2 = new Player("Player2", new Position(field.getWidth() - padding * 2, field.getHeight() / 2), Color.GREEN);
    }

    public void gameStart() {

    }

    public void collide() {
        //verify if pos equals pos
    }

    public void moveAll() {
        //move all objects
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case (KeyboardEvent.KEY_W):
                break;
            case (KeyboardEvent.KEY_A):
                break;
            case (KeyboardEvent.KEY_S):
                break;
            case (KeyboardEvent.KEY_D):
                break;
            case (KeyboardEvent.KEY_SPACE):
                break;
            case (KeyboardEvent.KEY_UP):
                break;
            case (KeyboardEvent.KEY_LEFT):
                break;
            case (KeyboardEvent.KEY_DOWN):
                break;
            case (KeyboardEvent.KEY_RIGHT):
                break;
            case (KeyboardEvent.KEY_P):
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        switch (e.getKey()) {
            case (KeyboardEvent.KEY_W):
                break;
            case (KeyboardEvent.KEY_A):
                break;
            case (KeyboardEvent.KEY_S):
                break;
            case (KeyboardEvent.KEY_D):
                break;
            case (KeyboardEvent.KEY_SPACE):
                break;
            case (KeyboardEvent.KEY_UP):
                break;
            case (KeyboardEvent.KEY_LEFT):
                break;
            case (KeyboardEvent.KEY_DOWN):
                break;
            case (KeyboardEvent.KEY_RIGHT):
                break;
            case (KeyboardEvent.KEY_P):
                break;
        }

    }
}

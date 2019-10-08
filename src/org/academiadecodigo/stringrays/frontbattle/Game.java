package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Movables.Bullet;
import org.academiadecodigo.stringrays.frontbattle.Movables.Direction;
import org.academiadecodigo.stringrays.frontbattle.Movables.Player;

public class Game implements KeyboardHandler {


    private Player player1;
    private Player player2;
    private int padding = 10;
    private Field field;
    private boolean wKey, aKey, sKey, dKey, spaceKey, upKey, leftKey, downKey, rightKey, pKey;

    private Bullet[] bullet;

    public void creation() {
        field = new Field(25,25);
        field.init();

        player1 = new Player("player1", new Position(15,15, field), Color.ORANGE);
        player1.getPosition().show();

        //bullets
        bullet = new Bullet[100];
        for (int i = 0; i < bullet.length; i++) {
            bullet[i] = new Bullet(new Position(15, 15, field));
        }

    }

    public void gameStart() throws Exception {
        while (true) {
            moveAll();
            checkCollisions();
        }
    }

    public void checkCollisions() {

        for (int i = 0; i < bullet.length; i++) {

            //if bullet is not fired continue to next bullet
            if(!bullet[i].isFired()) {
                continue;
            }

            //check if bullet is out of range by left or right side of screen
            if (bullet[i].getPosition().getCol() < 0 || bullet[i].getPosition().getCol() > field.getWidth()) {
                bullet[i].setFired(false);
            }

            //check if bullet is out of range by top or lower side of screen
            if (bullet[i].getPosition().getRow() < 0 || bullet[i].getPosition().getRow() > field.getHeight()) {
                bullet[i].setFired(false);
            }

            //check if any bullet is hitting player 1
            if (player1.getPosition().equals(bullet[i].getPosition())) {
                player1.hit(bullet[i].getBulletDamage());
                bullet[i].setFired(false);
            }

            //check if any bullet is hitting player 2
            if (player2.getPosition().equals(bullet[i].getPosition())) {
                player2.hit(bullet[i].getBulletDamage());
                bullet[i].setFired(false);
            }

        }
    }

    public void moveAll() throws InterruptedException{
        Thread.sleep(555);

        while(upKey) {
            player1.move(Direction.UP);
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

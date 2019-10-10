package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.stringrays.frontbattle.Movables.Direction;
import org.academiadecodigo.stringrays.frontbattle.Movables.Player;
import org.academiadecodigo.stringrays.frontbattle.Movables.Bullet;

//import java.util.LinkedList;
//import java.util.List;

public class Game implements KeyboardHandler {

    private Player player1;
    private Player player2;
    private Field field;
    private boolean wKey, aKey, sKey, dKey, spaceKey, upKey, leftKey, downKey, rightKey, pKey;
    private Keyboard keyboard = new Keyboard(this);
    private int bulletCounter;
    private boolean bulletDelay = true;
    private Bullet[] bullets;
    //private Text playerOneHealth;
    //private Text playerTwoHealth;
    //private List<Bullet> bullets;


    public void creation() {
        field = new Field(80, 80);
        field.init();
        player1 = new Player("Player One", new Position(1, field.getRows() / 2, field, true), Color.BLUE, field, Direction.RIGHT);
        player1.getPosition().show();
        player2 = new Player("Player Two", new Position(field.getCols() - 2, field.getRows() / 2, field, true), Color.RED, field, Direction.LEFT);
        player2.getPosition().show();
        bullets = new Bullet[1000];

        //TODO: PLAYERS HEALTH SCORE BOARD

        //Rectangle playerOneHealth = new Rectangle(Field.PADDING, field.getHeight() + Field.PADDING, player1.getHealth(), Field.PADDING );
        //playerOneHealth.fill();

        /*playerOneHealth = new Text(Field.PADDING, field.getHeight() + 20, player1.getName() + " " + player1.getHealth() + " %");
        playerTwoHealth = new Text(field.getWidth() - 100, field.getHeight() + 20,  player2.getName() + " " + player2.getHealth() + " %");
        playerOneHealth.draw();
        playerTwoHealth.draw();*/

        //bullets = new LinkedList<>();

    }

    public void gameStart() throws InterruptedException {

        keyboardKeys();

        while (true) {
            Thread.sleep(30);
            if (bulletDelay) {
                createBullets();
            }
            moveBullets();
            checkBulletBounds();
            movePlayers();
            bulletDelay = !bulletDelay;
            System.out.println(player1.getPosition().getCol());
        }
    }

    //TODO: IMPLEMENT SCORE BOARD


    /*
    public void scoreBoard() {

        playerOneHealth.delete();
        playerTwoHealth.delete();
        playerOneHealth = new Text(Field.PADDING, field.getHeight() + 20, player1.getName() + " " + player1.getHealth() + " %");
        playerTwoHealth = new Text(field.getWidth() - 100, field.getHeight() + 20,  player2.getName() + " " + player2.getHealth() + " %");
        playerOneHealth.draw();
        playerTwoHealth.draw();

    }
    */

    public void checkBulletHits() {

        //TODO: CHANGE BULLET ARRAY TO LIST
        /*
        System.out.println(bulletCounter);

        Iterator<Bullet> bulletIterator = bullets.iterator();

        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();

            if bulletIterator.next()

            if () {
                bulletIterator.remove();
            }

        }
        */

        for (int i = 0; i < bullets.length; i++) {

            //if position is null or bullet is not fired, continue
            if (bullets[i] == null || !bullets[i].isFired()) {
                continue;
            }

            //check if any bullet is hitting player 1
            if (player1.getPosition().equals(bullets[i].getPosition())) {
                player1.hit(bullets[i].getBulletDamage());
                bullets[i].setFired(false);
                continue;
            }

            //check if any bullet is hitting player 2
            if (player2.getPosition().equals(bullets[i].getPosition())) {
                player2.hit(bullets[i].getBulletDamage());
                bullets[i].setFired(false);
            }
        }

        if (bulletCounter >= 999) {
            bulletCounter = 0;
        }
    }

    public void checkBulletBounds() {

        //check if bullet is out of screen
        for (int i = 0; i < bullets.length; i++) {

            if (bullets[i] == null || !bullets[i].isFired()) {
                continue;
            }

            if (bullets[i].getPosition().getCol() == 0 || bullets[i].getPosition().getCol() == field.getCols() - 1) {
                bullets[i].setFired(false);
                bullets[i] = null;
                continue;
            }

            if (bullets[i].getPosition().getRow() == 0 || bullets[i].getPosition().getRow() == field.getRows() - 1) {
                bullets[i].setFired(false);
                bullets[i] = null;
            }
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

        if (upKey) {
            if (player2.getPosition().getCol() != player1.getPosition().getCol() ||
                    player2.getPosition().getRow() != player1.getPosition().getRow() + 1) {
                player2.getPosition().moveUp();
            }
        }
        if (downKey) {
            if (player2.getPosition().getCol() != player1.getPosition().getCol() ||
                    player2.getPosition().getRow() != player1.getPosition().getRow() - 1) {
                player2.getPosition().moveDown();
            }
        }
        if (rightKey) {
            if (player2.getPosition().getCol() != player1.getPosition().getCol() - 1 ||
                    player2.getPosition().getRow() != player1.getPosition().getRow()) {
                player2.getPosition().moveRight();
            }
        }
        if (leftKey) {
            if (player2.getPosition().getCol() != player1.getPosition().getCol() + 1 ||
                    player2.getPosition().getRow() != player1.getPosition().getRow()) {
                player2.getPosition().moveLeft();
            }
        }
        if (wKey) {
            if (player1.getPosition().getCol() != player2.getPosition().getCol() ||
                    player1.getPosition().getRow() != player2.getPosition().getRow() + 1) {
                player1.getPosition().moveUp();
            }
        }
        if (sKey) {
            if (player1.getPosition().getCol() != player2.getPosition().getCol() ||
                    player1.getPosition().getRow() != player2.getPosition().getRow() - 1) {
                player1.getPosition().moveDown();
            }
        }
        if (aKey) {
            if (player1.getPosition().getCol() != player2.getPosition().getCol() + 1 ||
                    player1.getPosition().getRow() != player2.getPosition().getRow()) {
                player1.getPosition().moveLeft();
            }
        }
        if (dKey) {
            if (player1.getPosition().getCol() != player2.getPosition().getCol() - 1 ||
                    player1.getPosition().getRow() != player2.getPosition().getRow()) {
                player1.getPosition().moveRight();
            }
        }
        checkBulletHits();
    }


    //TODO: DELETE CREATEBULLETS() EXCEPTION AND IMPLEMENT A REAL METHOD FOR ROUND MANAGEMENT

    public void createBullets() {
        try {
            if (spaceKey) {
                if (player1.getPosition().getCol() > 0 && player1.getPosition().getRow() > 0) {
                    Bullet newBullet = player1.attack();
                    if (newBullet != null) {
                        bullets[bulletCounter] = newBullet;
                        bullets[bulletCounter].setFired(true);
                        bulletCounter++;
                    }
                }
            }

            if (pKey) {
                if (player2.getPosition().getCol() > 0 && player2.getPosition().getRow() > 0) {
                    Bullet newBullet = player2.attack();
                    if (newBullet != null) {
                        bullets[bulletCounter] = newBullet;
                        bullets[bulletCounter].setFired(true);
                        bulletCounter++;
                    }
                }
            }

        } catch (Exception exception) {
            Text gameOver = new Text(field.getWidth() / 2, field.getHeight() / 2, "GAME OVER");
            gameOver.setColor(Color.BLACK);
            gameOver.grow(200, 40);
            gameOver.draw();
        }
    }

    public void moveBullets() {

        for (int i = 0; i < bullets.length; i++) {

            if (bullets[i] == null) {
                continue;
            }

            if (bullets[i].isFired()) {
                bullets[i].move();
            }
        }
        checkBulletHits();
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

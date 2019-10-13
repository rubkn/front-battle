package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public class Menu implements KeyboardHandler {

    private Field field = new Field();
    private Picture background;
    private Game game;

    //keyboard
    private Keyboard keyboard = new Keyboard(this);
    //menu boxes
    private Rectangle playBox;
    private Rectangle quitBox;
    private Rectangle gameoverrect;
    //texts
    private Text gameName;
    private Text startText;
    private Text quitText;
    private boolean sKeyPressed;
    private boolean qKeyPressed;
    private boolean mKeyPressed;

    //show menu
    public void startMenu() {
        keyboardKeys();
        /**field init*/
        background = new Picture(Field.PADDING, Field.PADDING, "img/field/field1.png");
        background.draw();
        /**init playboxes*/
        playBox = new Rectangle((field.getWidth() / 2) - 115, (field.getHeight() / 2) - 40,
                330, 80);
        quitBox = new Rectangle((field.getWidth() / 2) - 115, (field.getHeight() / 2) - 40,
                330, 80);
        /**init texts*/
        gameName = new Text((field.getWidth() / 2) + 200,
                (field.getHeight() / 2) - 250, "Game Name");
        startText = new Text((field.getWidth() / 2) + 160,
                (field.getHeight() / 2) - 17, "START (press S)");
        quitText = new Text((field.getWidth() / 2) + 160,
                (field.getHeight() / 2) + 100, "QUIT (press Q)");
        gameName.grow(100, 10);
        startText.grow(50, 10);
        quitText.grow(50, 10);
        /**boxes*/
        playBox.draw();
        playBox.fill();
        playBox.setColor(Color.WHITE);
        quitBox.draw();
        quitBox.fill();
        quitBox.setColor(Color.WHITE);
        /**text*/
        gameName.draw();
        startText.draw();
        startText.setColor(Color.BLACK);
        quitText.draw();
        quitText.setColor(Color.BLACK);

        try {
            while(!sKeyPressed && !qKeyPressed){
                Thread.sleep(30);
            }
            if (sKeyPressed) {
                game = new Game();
                game.creation();
                game.gameStart(this);
            }
            if (qKeyPressed) {
                System.exit(0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void gameOverMenu() {
        keyboardKeys();
        gameoverrect = new Rectangle(field.getWidth() / 2, field.getHeight() / 2, 100, 100);
        gameoverrect.draw();
        try{
            while(!mKeyPressed) {
                Thread.sleep(30);
            }
            startMenu();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * keyboard events
     */

    public void addKeyboardEvent(int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }

    public void keyboardKeys() {
        addKeyboardEvent(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_S, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_M, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_M, KeyboardEventType.KEY_RELEASED);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_S:
                sKeyPressed = true;
                break;
            case KeyboardEvent.KEY_Q:
                qKeyPressed = true;
                break;
            case KeyboardEvent.KEY_M:
                mKeyPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_S:
                sKeyPressed = false;
                break;
            case KeyboardEvent.KEY_Q:
                qKeyPressed = false;
                break;
            case KeyboardEvent.KEY_M:
                mKeyPressed = false;
                break;
        }
    }
}

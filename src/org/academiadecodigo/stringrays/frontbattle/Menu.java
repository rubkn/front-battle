package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private Field field = new Field();
    private Keyboard keyboard = new Keyboard(this);
    private boolean sKeyPressed;
    private boolean qKeyPressed;
    private boolean mKeyPressed;
    private Sound openingSound;
    private Sound gameSound;

    //show menu
    public void startMenu() {
        keyboardKeys();

        Picture background = new Picture(Field.PADDING, Field.PADDING, "resources/img/menu/menu.png");
        background.draw();

        openingSound = new Sound("/resources/soundfx/menusoundtrack.wav");
        openingSound.play(true);

        try {
            while(!sKeyPressed && !qKeyPressed){
                Thread.sleep(30);
            }
            if (sKeyPressed) {
                Game game = new Game();
                openingSound.stop();
                gameSound = new Sound("/resources/soundfx/battlesoundtrack.wav");
                gameSound.play(true);
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

    public void gameOverMenu(String path) {
        keyboardKeys();
        Picture winner = new Picture(field.getX(),field.getY(),path);
        winner.draw();
        try{
            while(!mKeyPressed) {
                Thread.sleep(30);
            }
            gameSound.stop();
            startMenu();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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

package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameOver {

    public static void gameOver(Field field) {
        Text gameOver = new Text(field.getWidth() / 2, field.getHeight() / 2, "GAME OVER");
        gameOver.setColor(Color.BLACK);
        gameOver.grow(200, 40);
        gameOver.draw();
    }
}

package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameOver {

    public static void gameOver(Field field, Player player1, Player player2) {
        Text gameOver = new Text(field.getWidth() / 2, field.getHeight() / 2, "GAME OVER");
        if (player1.getHealth() > 0) {
            Text playerOneWins = new Text(field.getWidth() / 2, (field.getHeight() / 2) + 80, "PLAYER ONE WINS!");
            playerOneWins.setColor(Color.WHITE);
            playerOneWins.grow(200, 40);
            playerOneWins.draw();
        }
        if (player2.getHealth() > 0) {
            Text playerTwoWins = new Text(field.getWidth() / 2, (field.getHeight() / 2) + 80, "PLAYER ONE WINS!");
            playerTwoWins.setColor(Color.WHITE);
            playerTwoWins.grow(200, 40);
            playerTwoWins.draw();
        }
        gameOver.setColor(Color.WHITE);
        gameOver.grow(200, 40);
        gameOver.draw();
    }
}

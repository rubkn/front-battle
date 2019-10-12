package org.academiadecodigo.stringrays.frontbattle;

public class Collision {

    private Position position;

    public boolean checkUp (Player playerMoving, Player otherPlayer) {
        /*if (playerMoving.getPosition().getY() > otherPlayer.getPosition().getY() + otherPlayer.getPosition().getMaxY()
            && playerMoving.getPosition().getX() > otherPlayer.getPosition().getMaxX()
        }*/
                //playerMoving.getPosition().getY() > otherPlayer.getPosition().getY() + otherPlayer.getPosition().getMaxY())

           return((playerMoving.getPosition().getY() == otherPlayer.getPosition().getMaxY() && playerMoving.) &&
                    playerMoving.getPosition().getX() == otherPlayer.getPosition().getX() && playerMoving.getPosition().getX() + playerMoving.getPosition().getMaxX() == otherPlayer.getPosition().getX() + otherPlayer.getPosition().getMaxX());

    }
}

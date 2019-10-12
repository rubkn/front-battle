package org.academiadecodigo.stringrays.frontbattle;

public class Collision {

    public boolean checkUp(Player playerMoving, Player otherPlayer, Direction direction) {
        /*if (playerMoving.getPosition().getY() > otherPlayer.getPosition().getY() + otherPlayer.getPosition().getMaxY()
            && playerMoving.getPosition().getX() > otherPlayer.getPosition().getMaxX()
        }*/
        //playerMoving.getPosition().getY() > otherPlayer.getPosition().getY() + otherPlayer.getPosition().getMaxY())

        boolean colliding = false;

        if ((playerMoving.getPosition().getMaxX()) >= (otherPlayer.getPosition().getX()) &&
                (playerMoving.getPosition().getX()) <= (otherPlayer.getPosition().getMaxX()) &&
                (playerMoving.getPosition().getMaxY()) >= (otherPlayer.getPosition().getY()) &&
                (playerMoving.getPosition().getY()) <= (otherPlayer.getPosition().getMaxY())) {
            colliding = true;
        }

        if (colliding && direction == Direction.UP && playerMoving.getPosition().getY() == otherPlayer.getPosition().getMaxY()) {
            return true;
        }

        if (colliding && direction == Direction.DOWN && playerMoving.getPosition().getMaxY() == otherPlayer.getPosition().getY()) {
            return true;
        }

        if (colliding && direction == Direction.LEFT && playerMoving.getPosition().getX() == otherPlayer.getPosition().getMaxX()) {
            return true;
        }

        if (colliding && direction == Direction.RIGHT && playerMoving.getPosition().getMaxX() == otherPlayer.getPosition().getX()) {
            return true;
        }

        return false;
    }
}

package org.academiadecodigo.stringrays.frontbattle;

public class Collision {

    public boolean movableCollisions(Player playerMoving, Player otherPlayer, Direction direction) {

        boolean colliding = false;

        if ((playerMoving.getPosition().getMaxX()) >= (otherPlayer.getPosition().getX()) &&
                (playerMoving.getPosition().getX()) <= (otherPlayer.getPosition().getMaxX()) &&
                (playerMoving.getPosition().getMaxY()) >= (otherPlayer.getPosition().getY()) &&
                (playerMoving.getPosition().getY()) <= (otherPlayer.getPosition().getMaxY())) {
            colliding = true;
        }

        //TODO DECIDE IF 4 IF'S OR 1 LONG FUCKING IF
        /*
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
        */

        if (colliding && direction == Direction.UP && playerMoving.getPosition().getY() == otherPlayer.getPosition().getMaxY() ||
                colliding && direction == Direction.DOWN && playerMoving.getPosition().getMaxY() == otherPlayer.getPosition().getY() ||
                colliding && direction == Direction.LEFT && playerMoving.getPosition().getX() == otherPlayer.getPosition().getMaxX() ||
                colliding && direction == Direction.RIGHT && playerMoving.getPosition().getMaxX() == otherPlayer.getPosition().getX()) {
            return true;
        }

        return false;
    }

    //TODO ASK MCs IF WE SHOULD USE A METHOD FOR BOUNDARIES COLLISION OR CHECK WHEN WE MOVE THE PLAYER
    /*
    public boolean fieldCollisions(Player playerMoving, Field field, Direction direction) {

        boolean colliding = false;

        if ((playerMoving.getPosition().getMaxX()) == (field.getWidth() + 10) ||
                (playerMoving.getPosition().getX()) == (field.getX()) ||
                (playerMoving.getPosition().getMaxY()) == (field.getHeight() + Field.PADDING) ||
                (playerMoving.getPosition().getY()) == (field.getY())) {
            colliding = true;
        }

        System.out.println(colliding);

        /*
        if (colliding && direction == Direction.UP && playerMoving.getPosition().getY() == field.getY() ||
                colliding && direction == Direction.DOWN && playerMoving.getPosition().getMaxY() == field.getHeight() ||
                colliding && direction == Direction.LEFT && playerMoving.getPosition().getX() == field.getX() ||
                colliding && direction == Direction.RIGHT && playerMoving.getPosition().getMaxX() == field.getWidth()) {
            return true;
        }

            return colliding;
        }
        */
}

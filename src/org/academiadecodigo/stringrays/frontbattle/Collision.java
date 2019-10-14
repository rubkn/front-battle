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

        if (
                colliding && direction == Direction.UP && playerMoving.getPosition().getY() == otherPlayer.getPosition().getMaxY() ||
                colliding && direction == Direction.DOWN && playerMoving.getPosition().getMaxY() == otherPlayer.getPosition().getY() ||
                colliding && direction == Direction.LEFT && playerMoving.getPosition().getX() == otherPlayer.getPosition().getMaxX() ||
                colliding && direction == Direction.RIGHT && playerMoving.getPosition().getMaxX() == otherPlayer.getPosition().getX() ||

                colliding && direction == Direction.UPRIGHT && playerMoving.getPosition().getY() == otherPlayer.getPosition().getMaxY() ||
                colliding && direction == Direction.UPRIGHT && playerMoving.getPosition().getMaxX() == otherPlayer.getPosition().getX() ||

                colliding && direction == Direction.UPLEFT && playerMoving.getPosition().getX() == otherPlayer.getPosition().getMaxX() ||
                colliding && direction == Direction.UPLEFT && playerMoving.getPosition().getY() == otherPlayer.getPosition().getMaxY() ||

                colliding && direction == Direction.DOWNLEFT && playerMoving.getPosition().getMaxY() == otherPlayer.getPosition().getY() ||
                colliding && direction == Direction.DOWNLEFT && playerMoving.getPosition().getX() == otherPlayer.getPosition().getMaxX() ||

                colliding && direction == Direction.DOWNRIGHT && playerMoving.getPosition().getMaxY() == otherPlayer.getPosition().getY() ||
                colliding && direction == Direction.DOWNRIGHT && playerMoving.getPosition().getMaxX() == otherPlayer.getPosition().getX()
        ) {
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

    public void checkBulletBounds(Bullet[] bullets, Field field) {

        for (int i = 0; i < bullets.length; i++) {

            //if bullets array position returns null or is not fired continue to next bullet
            if (bullets[i] == null || !bullets[i].isFired()) {
                continue;
            }

            //checks if bullet is out of bounds by left or right side of arena
            if (bullets[i].getPosition().getX() <= field.getX() || bullets[i].getPosition().getMaxX() >= field.getWidth() + Field.PADDING) {
                bullets[i].setFired(false);
                bullets[i] = null;
                continue;
            }

            //checks if bullet is out of bounds by top or bottom side of arena
            if (bullets[i].getPosition().getY() <= field.getY() || bullets[i].getPosition().getMaxY() >= field.getHeight() + Field.PADDING) {
                bullets[i].setFired(false);
                bullets[i] = null;
            }
        }
    }

    public void checkBulletHits(Player player1, Player player2, Bullet[] bullets) {

        for (int i = 0; i < bullets.length; i++) {

            //if position is null or bullet is not fired, continue
            if (bullets[i] == null || !bullets[i].isFired()) {
                continue;
            }

            //check if any bullet is hitting player 1
            if (player1.getPosition().colliding(bullets[i].getPosition())) {
                player1.hit(bullets[i].getBulletDamage());
                player1.move(bullets[i].getDirection(), 15);
                bullets[i].setFired(false);
                bullets[i] = null;
                continue;
            }

            //check if any bullet is hitting player 2
            if (player2.getPosition().colliding(bullets[i].getPosition())) {
                player2.hit(bullets[i].getBulletDamage());
                player2.move(bullets[i].getDirection(), 15);
                bullets[i].setFired(false);
                bullets[i] = null;
            }
        }
    }
}

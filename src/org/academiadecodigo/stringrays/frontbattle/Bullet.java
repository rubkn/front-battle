package org.academiadecodigo.stringrays.frontbattle;

public class Bullet {

    private Position position;
    private int damage;
    private boolean isFired;

    public Bullet() {
        position = new Position(0, 0);
        damage = 10;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isFired() {
        return isFired;
    }
}

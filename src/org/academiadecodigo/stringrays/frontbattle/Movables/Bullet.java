package org.academiadecodigo.stringrays.frontbattle.Movables;

import org.academiadecodigo.stringrays.frontbattle.Field;
import org.academiadecodigo.stringrays.frontbattle.Position;

public class Bullet implements Movables {

    private Position position;
    private int bulletDamage;
    private boolean isFired;
    private Field field;

    public Bullet(Position position) {
        this.position = position;
        bulletDamage = 10;
    }

    @Override
    public void move(Direction direction) {

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

    public void setFired(boolean fired) {
        isFired = fired;
    }

    public int getBulletDamage() {
        return bulletDamage;
    }
}
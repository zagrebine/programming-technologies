package model;

import contracts.Moveable;

public class MobileHouse extends Building implements Moveable {
    public MobileHouse(int id, String name, int x, int y, boolean isBuilt) {
        super(id, name, x, y, isBuilt);
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

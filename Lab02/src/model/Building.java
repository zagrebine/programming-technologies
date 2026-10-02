package model;

import contracts.Damageable;

public class Building extends GameObject{
    private boolean isBuilt;

    public Building(int id, String name, int x, int y, boolean isBuilt) {
        super(id, name, x, y);
        this.isBuilt = isBuilt;
    }

    public boolean isBuilt() {
        return isBuilt;
    }

}

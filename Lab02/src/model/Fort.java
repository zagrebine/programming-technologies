package model;

import contracts.Attacker;
import contracts.Damageable;

public class Fort extends Building implements Attacker {
    public Fort(int id, String name, int x, int y, boolean isBuilt) {
        super(id, name, x, y, isBuilt);
    }

    @Override
    public void attack(Damageable enemy) {
        enemy.receiveDamage(50);
    }
}

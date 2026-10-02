package model;

import contracts.Attacker;
import contracts.Damageable;
import contracts.Moveable;

public class Archer extends Unit implements Attacker, Moveable {

    public Archer(int id, String name, int x, int y) {
        super(id, name, x, y);
    }

    @Override
    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void attack(Damageable enemy) {
        enemy.receiveDamage(20);
    }
}

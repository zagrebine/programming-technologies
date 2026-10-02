package model;

import contracts.Damageable;

public class Unit extends GameObject implements Damageable {
    protected float hp;

    public Unit(int id, String name, int x, int y) {
        super(id, name, x, y);
        this.hp = 100F;
    }

    public boolean isAlive(){
        return hp > 0;
    }


    public float getHp() {
        return hp;
    }

    @Override
    public void receiveDamage(float damage){
        this.hp -= damage;

        if (hp <= 0){
            hp = 0;
        }
    }

}

package Builder.Builders;

import Builder.Unit;

public class ArcherBuilder implements UnitBuilder {
    private Unit unit;

    public ArcherBuilder() {
        this.unit = new Unit();
    }

    @Override
    public void buildName() {
        unit.setName("Лучник");
    }

    @Override
    public void buildHealth() {
        unit.setHealth(100);
    }

    @Override
    public void buildStrength() {
        unit.setStrength(15);
    }

    @Override
    public void buildWeapon() {
        unit.setWeapon("Лук");
    }

    @Override
    public Unit getResult() {
        return unit;
    }
}
package Builder.Builders;

import Builder.Unit;

public class WarriorBuilder implements UnitBuilder {
    private Unit unit;

    public WarriorBuilder() {
        this.unit = new Unit();
    }

    @Override
    public void buildName() {
        unit.setName("Воин");
    }

    @Override
    public void buildHealth() {
        unit.setHealth(200);
    }

    @Override
    public void buildStrength() {
        unit.setStrength(30);
    }

    @Override
    public void buildWeapon() {
        unit.setWeapon("Меч");
    }

    @Override
    public Unit getResult() {
        return unit;
    }
}
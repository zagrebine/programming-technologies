package Builder.Builders;

import Builder.Unit;

public interface UnitBuilder {
    void buildName();
    void buildHealth();
    void buildStrength();
    void buildWeapon();

    Unit getResult();
}
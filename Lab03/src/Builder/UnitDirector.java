package Builder;
import Builder.Builders.UnitBuilder;

public class UnitDirector {
    private UnitBuilder builder;

    public UnitDirector(UnitBuilder builder) {
        this.builder = builder;
    }

    public void constructUnit() {
        builder.buildName();
        builder.buildHealth();
        builder.buildStrength();
        builder.buildWeapon();
    }
}
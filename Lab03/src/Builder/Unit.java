package Builder;

public class Unit {
    private String name;
    private int health;
    private int strength;
    private String weapon;

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "{" +
                "name = '" + name +
                ", health = " + health +
                ", strength = " + strength +
                ", weapon = '" + weapon +
                "}";
    }
}
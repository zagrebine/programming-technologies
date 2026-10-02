import model.Archer;
import model.Fort;
import model.MobileHouse;
import model.Unit;

public class Main {

    public static void main(String[] args) {

        // =========================
        // Создание объектов
        // =========================

        Archer archer = new Archer(
                1,
                "Robin",
                10,
                20
        );

        Unit enemy = new Unit(
                2,
                "Enemy",
                50,
                50
        );

        Fort fort = new Fort(
                3,
                "Fort",
                100,
                100,
                true
        );

        MobileHouse house = new MobileHouse(
                4,
                "Mobile House",
                200,
                200,
                true
        );


        // =========================
        // GameObject
        // =========================

        System.out.println("=== GameObject ===");

        System.out.println("Archer ID: " + archer.getId());
        System.out.println("Archer name: " + archer.getName());
        System.out.println(
                "Archer position: "
                        + archer.getX()
                        + ", "
                        + archer.getY()
        );


        // =========================
        // Unit
        // =========================

        System.out.println("\n=== Unit ===");

        System.out.println("Enemy HP: " + enemy.getHp());
        System.out.println("Enemy alive: " + enemy.isAlive());


        // =========================
        // Archer attack
        // =========================

        System.out.println("\n=== Archer attack ===");

        archer.attack(enemy);

        System.out.println(
                "Enemy HP after Archer attack: "
                        + enemy.getHp()
        );

        System.out.println(
                "Enemy alive: "
                        + enemy.isAlive()
        );


        // =========================
        // Fort attack
        // =========================

        System.out.println("\n=== Fort attack ===");

        fort.attack(enemy);

        System.out.println(
                "Enemy HP after Fort attack: "
                        + enemy.getHp()
        );

        System.out.println(
                "Enemy alive: "
                        + enemy.isAlive()
        );


        // =========================
        // Archer movement
        // =========================

        System.out.println("\n=== Archer movement ===");

        System.out.println(
                "Before: "
                        + archer.getX()
                        + ", "
                        + archer.getY()
        );

        archer.move(100, 200);

        System.out.println(
                "After: "
                        + archer.getX()
                        + ", "
                        + archer.getY()
        );


        // =========================
        // MobileHouse movement
        // =========================

        System.out.println("\n=== MobileHouse movement ===");

        System.out.println(
                "Before: "
                        + house.getX()
                        + ", "
                        + house.getY()
        );

        house.move(300, 400);

        System.out.println(
                "After: "
                        + house.getX()
                        + ", "
                        + house.getY()
        );


        // =========================
        // Building
        // =========================

        System.out.println("\n=== Buildings ===");

        System.out.println(
                "Fort built: "
                        + fort.isBuilt()
        );

        System.out.println(
                "MobileHouse built: "
                        + house.isBuilt()
        );


        // =========================
        // Проверка смерти Unit
        // =========================

        System.out.println("\n=== Death test ===");

        Unit testUnit = new Unit(
                5,
                "Test Unit",
                0,
                0
        );

        System.out.println(
                "Initial HP: "
                        + testUnit.getHp()
        );

        System.out.println(
                "Initial alive: "
                        + testUnit.isAlive()
        );

        testUnit.receiveDamage(100);

        System.out.println(
                "HP after 100 damage: "
                        + testUnit.getHp()
        );

        System.out.println(
                "Alive after 100 damage: "
                        + testUnit.isAlive()
        );

        // Проверяем, что HP не становится отрицательным
        testUnit.receiveDamage(50);

        System.out.println(
                "HP after additional 50 damage: "
                        + testUnit.getHp()
        );

        System.out.println(
                "Alive: "
                        + testUnit.isAlive()
        );
    }
}
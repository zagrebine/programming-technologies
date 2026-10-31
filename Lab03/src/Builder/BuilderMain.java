package Builder;

import Builder.Builders.ArcherBuilder;
import Builder.Builders.UnitBuilder;
import Builder.Builders.WarriorBuilder;

public class BuilderMain {
    public static void main(String[] args) {

        UnitBuilder warriorBuilder = new WarriorBuilder();
        UnitDirector director = new UnitDirector(warriorBuilder);

        director.constructUnit();
        Unit warrior = warriorBuilder.getResult();

        System.out.println(warrior);

        UnitBuilder archerBuilder = new ArcherBuilder();
        director = new UnitDirector(archerBuilder);

        director.constructUnit();
        Unit archer = archerBuilder.getResult();

        System.out.println(archer);
    }
}
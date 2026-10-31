# Лабораторная работа №3

## Тема: Паттерны проектирования (Design Patterns)

Изучение основных паттернов проектирования программного обеспечения, их назначения, принципов работы и практическая реализация на языке программирования Java.

## 1. Паттерн Singleton

### Описание

Реализован паттерн Singleton, обеспечивающий существование только одного экземпляра класса `AppConfig`.

Класс хранит конфигурационные параметры приложения. Приватный конструктор запрещает создание объектов извне, а статический метод `getAppConfig()` возвращает единственный экземпляр. Модификатор `synchronized` обеспечивает потокобезопасность создания объекта.

### Реализация

**Класс AppConfig:**

```java
package Singleton;

public class AppConfig {
    private static AppConfig appConfig;
    private String appName;
    private int serverPort;
    private boolean testMode;

    private AppConfig() {
        this.appName = "MyApp";
        this.serverPort = 1337;
        this.testMode = false;
    }

    public static synchronized AppConfig getAppConfig() {
        if (appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    public boolean testMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }
}
```

**Класс Calculator:**

```java
package Singleton;

import java.util.function.BinaryOperator;

public class Calculator {
    public static int execute(int a, int b,
                              BinaryOperator<Integer> operator,
                              AppConfig config) {
        if (config.testMode()) {
            System.out.println("[TEST] Выполняется операция чисел: " + a + ',' + b);
            config.setTestMode(false);
            return operator.apply(a, b);
        }

        System.out.println("[NOT TEST] Выполняется операция чисел: " + a + ',' + b);
        return operator.apply(a, b);
    }
}
```

**Класс SingletonMain:**

```java
package Singleton;

import java.util.function.BinaryOperator;

public class SingletonMain {
    public static void main(String[] args) {
        BinaryOperator<Integer> addition = (a, b) -> a + b;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        AppConfig config = AppConfig.getAppConfig();
        config.setTestMode(true);

        int a = 5;
        int b = 6;

        System.out.println(Calculator.execute(a, b, addition, config));
        System.out.println(Calculator.execute(a, b, multiply, config));

        AppConfig config2 = AppConfig.getAppConfig();
        System.out.println(config == config2);
    }
}
```

### Консольный вывод

```text
[TEST] Выполняется операция чисел: 5,6
11
[NOT TEST] Выполняется операция чисел: 5,6
30
true

Process finished with exit code 0
```

Первое обращение выполняется в тестовом режиме, второе — в обычном. Последнее значение `true` подтверждает, что оба обращения к `getAppConfig()` возвращают один экземпляр класса `AppConfig`.

### Результат и вывод

В ходе выполнения программы проверена работа конфигурации в тестовом и обычном режимах, а также выполнены операции сложения и умножения.

Сравнение двух ссылок на экземпляр `AppConfig` с помощью оператора `==` возвращает `true`, что подтверждает использование одного и того же объекта.

Таким образом, паттерн Singleton позволяет обеспечить единый экземпляр конфигурации и использовать его в разных частях приложения.

## 2. Паттерн Factory Method

### Описание

Реализован паттерн Factory Method, позволяющий делегировать создание объектов конкретным подклассам.

В качестве примера разработана система отправки уведомлений. Поддерживаются два типа уведомлений: Email и SMS. Абстрактная фабрика `NotificationFactory` определяет метод создания уведомления и общий метод `sendMessage()`, а конкретные фабрики определяют, какой объект необходимо создать.

### Реализация

**Интерфейс Notification:**

```java
package FactoryMethod;

public interface Notification {
    void send(String message);
}
```

**Абстрактный класс NotificationFactory:**

```java
package FactoryMethod;

public abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void sendMessage(String message) {
        var notification = createNotification();
        notification.send(message);
    }
}
```

**Класс EmailNotification:**

```java
package FactoryMethod.Notificators;

import FactoryMethod.Notification;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email: " + "'" + message + "'" + " is sent");
    }
}
```

**Класс SmsNotification:**

```java
package FactoryMethod.Notificators;

import FactoryMethod.Notification;

public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS: " + "'" + message + "'" + " is sent");
    }
}
```

**Класс EmailNotificationFactory:**

```java
package FactoryMethod.Factories;

import FactoryMethod.Notification;
import FactoryMethod.NotificationFactory;
import FactoryMethod.Notificators.EmailNotification;

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
```

**Класс SmsNotificationFactory:**

```java
package FactoryMethod.Factories;

import FactoryMethod.Notification;
import FactoryMethod.NotificationFactory;
import FactoryMethod.Notificators.SmsNotification;

public class SmsNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
```

**Класс FactoryMain:**

```java
package FactoryMethod;

import FactoryMethod.Factories.EmailNotificationFactory;
import FactoryMethod.Factories.SmsNotificationFactory;

public class FactoryMain {
    public static void main(String[] args) {
        NotificationFactory factory = new EmailNotificationFactory();
        factory.sendMessage("Привет!");

        factory = new SmsNotificationFactory();
        factory.sendMessage("Привет!");
    }
}
```

### Консольный вывод

```text
Email: 'Привет!' is sent
SMS: 'Привет!' is sent

Process finished with exit code 0
```

### Результат и вывод

В ходе выполнения программы реализована система отправки уведомлений с использованием двух конкретных фабрик: `EmailNotificationFactory` и `SmsNotificationFactory`.

В зависимости от выбранной фабрики создаётся соответствующий объект уведомления. Общий метод `sendMessage()` работает через интерфейс `Notification`, не завися от конкретной реализации.

Таким образом, паттерн Factory Method позволяет отделить создание объектов от их использования и упрощает добавление новых типов уведомлений.


## 3. Паттерн Abstract Factory

### Описание

Реализован паттерн Abstract Factory, предназначенный для создания семейств взаимосвязанных объектов без привязки к их конкретным реализациям.

В качестве примера разработана система обработки доставки. Предусмотрено два типа доставки: классическая и курьерская. Для каждого типа создаются два взаимосвязанных объекта: калькулятор стоимости доставки и документы.

### Реализация

**Интерфейс DeliveryCalculator:**

```java
package AbstractFactory;

public interface DeliveryCalculator {
    void calculate();
}
```

**Интерфейс DeliveryDocuments:**

```java
package AbstractFactory;

public interface DeliveryDocuments {
    void createDocs();
}
```

**Интерфейс DeliveryFactory:**

```java
package AbstractFactory.Factory;

import AbstractFactory.DeliveryCalculator;
import AbstractFactory.DeliveryDocuments;

public interface DeliveryFactory {
    DeliveryCalculator calculator();
    DeliveryDocuments createDocuments();
}
```

**Класс ClassicCalculator:**

```java
package AbstractFactory.ClassicDelivery;

import AbstractFactory.DeliveryCalculator;

public class ClassicCalculator implements DeliveryCalculator {
    @Override
    public void calculate() {
        System.out.println("Классическая доставка рассчитана!");
    }
}
```

**Класс ClassicDocs:**

```java
package AbstractFactory.ClassicDelivery;

import AbstractFactory.DeliveryDocuments;

public class ClassicDocs implements DeliveryDocuments {
    @Override
    public void createDocs() {
        System.out.println("Созданы документы для классической доставки!");
    }
}
```

**Класс CourierCalculator:**

```java
package AbstractFactory.CourierDelivery;

import AbstractFactory.DeliveryCalculator;

public class CourierCalculator implements DeliveryCalculator {
    @Override
    public void calculate() {
        System.out.println("Доставка курьером рассчитана!");
    }
}
```

**Класс CourierDocs:**

```java
package AbstractFactory.CourierDelivery;

import AbstractFactory.DeliveryDocuments;

public class CourierDocs implements DeliveryDocuments {
    @Override
    public void createDocs() {
        System.out.println("Создана накладная для курьерской доставки!");
    }
}
```

**Класс ClassicFactory:**

```java
package AbstractFactory.Factory;

import AbstractFactory.ClassicDelivery.ClassicCalculator;
import AbstractFactory.ClassicDelivery.ClassicDocs;
import AbstractFactory.DeliveryCalculator;
import AbstractFactory.DeliveryDocuments;

public class ClassicFactory implements DeliveryFactory {
    @Override
    public DeliveryCalculator calculator() {
        return new ClassicCalculator();
    }

    @Override
    public DeliveryDocuments createDocuments() {
        return new ClassicDocs();
    }
}
```

**Класс CourierFactory:**

```java
package AbstractFactory.Factory;

import AbstractFactory.CourierDelivery.CourierCalculator;
import AbstractFactory.CourierDelivery.CourierDocs;
import AbstractFactory.DeliveryCalculator;
import AbstractFactory.DeliveryDocuments;

public class CourierFactory implements DeliveryFactory {

    @Override
    public DeliveryCalculator calculator() {
        return new CourierCalculator();
    }

    @Override
    public DeliveryDocuments createDocuments() {
        return new CourierDocs();
    }
}
```

**Класс DeliveryService:**

```java
package AbstractFactory;

import AbstractFactory.Factory.DeliveryFactory;

public class DeliveryService {
    private DeliveryCalculator calculator;
    private DeliveryDocuments documets;

    public DeliveryService(DeliveryFactory factory) {
        this.calculator = factory.calculator();
        this.documets = factory.createDocuments();
    }

    public void processDelivery() {
        calculator.calculate();
        documets.createDocs();
        System.out.println("Произведена обработка вашей доставки, спасибо что выбираете нас!");
    }
}
```

**Класс AbstractMain:**

```java
package AbstractFactory;

import AbstractFactory.Factory.ClassicFactory;
import AbstractFactory.Factory.CourierFactory;

public class AbstractMain {
    public static void main(String[] args) {
        var courierFactory = new CourierFactory();
        var classicFactory = new ClassicFactory();

        var service = new DeliveryService(courierFactory);
        service.processDelivery();

        System.out.println("");

        service = new DeliveryService(classicFactory);
        service.processDelivery();
    }
}
```

### Консольный вывод

```text
Доставка курьером рассчитана!
Создана накладная для курьерской доставки!
Произведена обработка вашей доставки, спасибо что выбираете нас!

Классическая доставка рассчитана!
Созданы документы для классической доставки!
Произведена обработка вашей доставки, спасибо что выбираете нас!

Process finished with exit code 0
```

### Результат и вывод

В ходе выполнения программы реализована система обработки доставки с использованием двух конкретных фабрик: `CourierFactory` и `ClassicFactory`.

Каждая фабрика создаёт соответствующее семейство объектов: калькулятор доставки и документы. Класс `DeliveryService` работает с абстрактными интерфейсами и не зависит от конкретных реализаций.

Таким образом, паттерн Abstract Factory позволяет создавать согласованные семейства объектов и переключаться между ними без изменения логики основного сервиса.


## 4. Паттерн Builder (Строитель)

### Описание

Паттерн **Builder (Строитель)** позволяет пошагово создавать сложные объекты, разделяя процесс их построения и конечное представление.

В данной реализации с помощью паттерна создаются игровые юниты двух типов: воин и лучник. Каждый юнит имеет имя, здоровье, силу и оружие. Для создания каждого типа используется отдельный строитель, а класс `UnitDirector` управляет последовательностью действий по сборке объекта.

### Реализация

**1. Интерфейс UnitBuilder**

Определяет общий набор методов для построения частей игрового юнита и получения готового объекта.

```java
package Builder.Builders;

import Builder.Unit;

public interface UnitBuilder {
    void buildName();
    void buildHealth();
    void buildStrength();
    void buildWeapon();

    Unit getResult();
}
```

**2. Класс WarriorBuilder**

Реализует построение юнита типа «Воин». Задаёт ему имя, здоровье, силу и оружие.

```java
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
```

**3. Класс ArcherBuilder**

Реализует построение юнита типа «Лучник» с собственными характеристиками.

```java
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
```

**4. Класс Unit**

Представляет игровой юнит. Содержит поля для хранения характеристик и переопределённый метод `toString()` для вывода информации об объекте.

```java
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
```

**5. Класс UnitDirector**

Управляет процессом создания юнита. Вызывает методы строителя в определённой последовательности.

```java
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
```

**6. Класс BuilderMain**

Демонстрирует создание двух игровых юнитов с помощью разных строителей и директора.

```java
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
```

### Консольный вывод

```text
{name = 'Воин, health = 200, strength = 30, weapon = 'Меч}
{name = 'Лучник, health = 100, strength = 15, weapon = 'Лук}

Process finished with exit code 0
```

### Результат и вывод

В результате работы программы были созданы два игровых юнита: воин и лучник. Каждый из них получил собственные характеристики, заданные соответствующим строителем.

Таким образом, паттерн **Builder** позволяет отделить процесс создания объекта от его конкретного представления. Использование общего интерфейса `UnitBuilder` даёт возможность создавать разные типы юнитов по единому алгоритму, а `UnitDirector` управляет последовательностью их сборки. Это упрощает расширение программы и добавление новых типов объектов.



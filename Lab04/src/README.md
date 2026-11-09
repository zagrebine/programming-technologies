# Паттерны проектирования

В данной работе реализованы три поведенческих паттерна проектирования: Strategy, Chain of Responsibility и Iterator. 

## 1. Strategy (Стратегия)

### Код

**PaymentStrategy.java**
```java
package Strategy;

public interface PaymentStrategy {
    void pay(int amount);
}
```

**PaymentProcessor.java**
```java
package Strategy;

public class PaymentProcessor {
    PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void process(int amount) {
        if (strategy == null) {
            throw new IllegalStateException("Метод оплаты не выбран");
        }
        strategy.pay(amount);
        System.out.println("Платеж обработан!");
    }
}
```

**CardPayment.java**
```java
package Strategy;

public class CardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Оплата картой!");
    }
}
```

**ApplePay.java**
```java
package Strategy;

public class ApplePay implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Оплата ApplePay!");
    }
}
```


## 2. Chain of Responsibility (Цепочка обязанностей)

### Код

**PaymentHandler.java**
```java
package ResponsibilityChain;

public interface PaymentHandler {
    void handle(Payment payment);
    void setNext(PaymentHandler handler);
}
```

**Payment.java**
```java
package ResponsibilityChain;

public class Payment {
    private PaymentType type;

    public Payment(PaymentType type) {
        this.type = type;
    }

    public PaymentType getType() {
        return type;
    }
}
```

**CardHandler.java**
```java
package ResponsibilityChain;

public class CardHandler implements PaymentHandler {
    private PaymentHandler next;

    @Override
    public void handle(Payment payment) {
        if (payment.getType() == PaymentType.CARD) {
            System.out.println("Обработка через CardHandler");
        } else if (next != null) {
            next.handle(payment);
        }
    }

    @Override
    public void setNext(PaymentHandler next) {
        this.next = next;
    }
}
```

**CryptoHandler.java**
```java
package ResponsibilityChain;

public class CryptoHandler implements PaymentHandler {
    private PaymentHandler next;

    @Override
    public void handle(Payment payment) {
        if (payment.getType() == PaymentType.CRYPTO) {
            System.out.println("Обработка через CryproHandler");
        } else if (next != null) {
            next.handle(payment);
        }
    }

    @Override
    public void setNext(PaymentHandler next) {
        this.next = next;
    }
}
```

**PaymentType.java**
```java
package ResponsibilityChain;

public enum PaymentType {
    CARD, CRYPTO
}
```

**RMain.java**
```java
package ResponsibilityChain;

public class RMain {
    public static void main(String[] args) {
        PaymentHandler card = new CardHandler();
        PaymentHandler crypto = new CryptoHandler();

        card.setNext(crypto);

        Payment payment1 = new Payment(PaymentType.CARD);
        Payment payment2 = new Payment(PaymentType.CRYPTO);

        card.handle(payment1);
        card.handle(payment2);
    }
}
```


## 3. Iterator (Итератор)

### Код

**Book.java**
```java
package Iterator;

public class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
```

**Iterator.java**
```java
package Iterator;

public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

**Library.java**
```java
package Iterator;

import java.util.ArrayList;
import java.util.List;

public class Library<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public Iterator<T> createIterator() {
        return new LibraryIterator<>(items);
    }
}
```

**LibraryIterator.java**
```java
package Iterator;

import java.util.List;

public class LibraryIterator<T> implements Iterator<T> {
    private List<T> items;
    private int position = 0;

    public LibraryIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public T next() {
        return items.get(position++);
    }
}
```

**IMain.java**
```java
package Iterator;

public class IMain {
    public static void main(String[] args) {
        var library = new Library<Book>();

        library.add(new Book("Евгений Онегин"));
        library.add(new Book("Герой нашего времени"));
        library.add(new Book("Чистый код"));

        Iterator<Book> iterator = library.createIterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }
}
```
 
package Strategy;

public class PaymentProcessor {
    PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void process(int amount){
        if(strategy == null){
            throw new IllegalStateException("Метод оплаты не выбран");
        }
        strategy.pay(amount);
        System.out.println("Платеж обработан!");
    }
}

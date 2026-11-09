package Strategy;

public class ApplePay implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Оплата ApplePay!");
    }
}

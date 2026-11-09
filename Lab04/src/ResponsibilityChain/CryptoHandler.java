package ResponsibilityChain;

public class CryptoHandler implements PaymentHandler{
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

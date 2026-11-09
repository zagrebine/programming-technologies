package ResponsibilityChain;

public class CardHandler implements PaymentHandler{
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

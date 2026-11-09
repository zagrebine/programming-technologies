package ResponsibilityChain;

public interface PaymentHandler {
    void handle(Payment payment);
    void setNext(PaymentHandler handler);

}

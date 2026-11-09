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

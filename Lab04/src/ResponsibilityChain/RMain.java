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

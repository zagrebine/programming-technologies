package AbstractFactory.CourierDelivery;

import AbstractFactory.DeliveryCalculator;

public class CourierCalculator implements DeliveryCalculator {
    @Override
    public void calculate() {
        System.out.println("Доставка курьером рассчитана!");
    }
}

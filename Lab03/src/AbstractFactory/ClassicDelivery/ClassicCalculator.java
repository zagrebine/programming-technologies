package AbstractFactory.ClassicDelivery;

import AbstractFactory.DeliveryCalculator;

public class ClassicCalculator implements DeliveryCalculator {
    @Override
    public void calculate() {
        System.out.println("Классическая доставка рассчитана!");
    }
}

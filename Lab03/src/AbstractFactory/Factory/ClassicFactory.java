package AbstractFactory.Factory;

import AbstractFactory.ClassicDelivery.ClassicCalculator;
import AbstractFactory.ClassicDelivery.ClassicDocs;
import AbstractFactory.DeliveryCalculator;
import AbstractFactory.DeliveryDocuments;

public class ClassicFactory implements DeliveryFactory{
    @Override
    public DeliveryCalculator calculator() {
        return new ClassicCalculator();
    }

    @Override
    public DeliveryDocuments createDocuments() {
        return new ClassicDocs();
    }
}

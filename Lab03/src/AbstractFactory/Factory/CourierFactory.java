package AbstractFactory.Factory;

import AbstractFactory.CourierDelivery.CourierCalculator;
import AbstractFactory.CourierDelivery.CourierDocs;
import AbstractFactory.DeliveryCalculator;
import AbstractFactory.DeliveryDocuments;

public class CourierFactory implements DeliveryFactory{

    @Override
    public DeliveryCalculator calculator() {
        return new CourierCalculator();
    }

    @Override
    public DeliveryDocuments createDocuments() {
        return new CourierDocs();
    }
}

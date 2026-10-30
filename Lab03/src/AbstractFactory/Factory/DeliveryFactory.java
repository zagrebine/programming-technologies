package AbstractFactory.Factory;

import AbstractFactory.DeliveryCalculator;
import AbstractFactory.DeliveryDocuments;

public interface DeliveryFactory{
    DeliveryCalculator calculator();
    DeliveryDocuments createDocuments();
}

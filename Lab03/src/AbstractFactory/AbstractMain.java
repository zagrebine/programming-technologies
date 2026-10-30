package AbstractFactory;

import AbstractFactory.Factory.ClassicFactory;
import AbstractFactory.Factory.CourierFactory;

public class AbstractMain{
    public static void main(String[] args){
        var courierFactory = new CourierFactory();
        var classicFactory = new ClassicFactory();

        var service = new DeliveryService(courierFactory);
        service.processDelivery();

        System.out.println("");

        service = new DeliveryService(classicFactory);
        service.processDelivery();

    }
}

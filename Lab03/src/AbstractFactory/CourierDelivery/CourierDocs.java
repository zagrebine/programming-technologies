package AbstractFactory.CourierDelivery;

import AbstractFactory.DeliveryDocuments;

public class CourierDocs implements DeliveryDocuments {
    @Override
    public void createDocs() {
        System.out.println("Создана накладная для курьерской доставки!");
    }
}

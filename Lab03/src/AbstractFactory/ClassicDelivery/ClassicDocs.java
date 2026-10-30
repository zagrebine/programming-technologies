package AbstractFactory.ClassicDelivery;

import AbstractFactory.DeliveryDocuments;

public class ClassicDocs implements DeliveryDocuments{
    @Override
    public void createDocs() {
        System.out.println("Созданы документы для классической доставки!");
    }
}

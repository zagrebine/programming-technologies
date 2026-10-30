package AbstractFactory;

import AbstractFactory.Factory.DeliveryFactory;

public class DeliveryService{
    private DeliveryCalculator calculator;
    private DeliveryDocuments documets;

    public DeliveryService(DeliveryFactory factory){
        this.calculator = factory.calculator();
        this.documets = factory.createDocuments();
    }

    public void processDelivery(){
        calculator.calculate();
        documets.createDocs();
        System.out.println("Произведена обработка вашей доставки, спасибо что выбираете нас!");
    }
}

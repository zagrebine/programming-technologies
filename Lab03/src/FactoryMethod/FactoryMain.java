package FactoryMethod;

import FactoryMethod.Factories.EmailNotificationFactory;
import FactoryMethod.Factories.SmsNotificationFactory;

public class FactoryMain{
    public static void main(String[] args){
        NotificationFactory factory = new EmailNotificationFactory();
        factory.sendMessage("Привет!");

        factory = new SmsNotificationFactory();
        factory.sendMessage("Привет!");
    }
}

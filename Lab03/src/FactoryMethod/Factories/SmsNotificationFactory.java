package FactoryMethod.Factories;

import FactoryMethod.Notification;
import FactoryMethod.NotificationFactory;
import FactoryMethod.Notificators.SmsNotification;

public class SmsNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification(){
        return new SmsNotification();
    }
}

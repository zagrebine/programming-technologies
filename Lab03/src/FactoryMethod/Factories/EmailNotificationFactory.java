package FactoryMethod.Factories;

import FactoryMethod.Notification;
import FactoryMethod.NotificationFactory;
import FactoryMethod.Notificators.EmailNotification;

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification(){
        return new EmailNotification();
    }

}

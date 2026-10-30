package FactoryMethod.Notificators;

import FactoryMethod.Notification;

public class EmailNotification implements Notification {
    @Override
    public void send(String message){
        System.out.println("Email: " + "'" + message + "'" + " is sent");
    }
}

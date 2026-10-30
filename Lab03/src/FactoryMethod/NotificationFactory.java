package FactoryMethod;

public abstract class NotificationFactory{
    public abstract Notification createNotification();

    public void sendMessage(String message){
        var notification = createNotification();
        notification.send(message);
    }
}

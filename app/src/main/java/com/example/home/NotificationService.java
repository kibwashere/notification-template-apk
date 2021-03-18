package com.example.home;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat;

public class NotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        notify(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    public void notify(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "notification_channel")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(123, builder.build());
    }
}

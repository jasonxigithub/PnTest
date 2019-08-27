package com.jason.pntest.PnTest.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

public class SendTopicMsg {
    public void sendToTopic() throws FirebaseMessagingException {
        String topic = "";
        Message message = Message.builder()
                .putData("scroe", "850")
                .putData("time", "2:45")
                .setTopic(topic)
                .build();
        String response = FirebaseMessaging.getInstance().send(message);
        
    }
}

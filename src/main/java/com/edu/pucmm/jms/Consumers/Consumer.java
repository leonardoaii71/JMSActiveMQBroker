package com.edu.pucmm.jms.Consumers;

import com.edu.pucmm.jms.Email;
import com.edu.pucmm.jms.EndPointMessage;
import com.pusher.rest.Pusher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Consumer {

    @Autowired
    Pusher pusherc;

    @JmsListener(destination = "notificacion_sensores")
    public void consume(EndPointMessage message) {
        pusherc.trigger("my-channel", "new-message", message);
        System.out.println("Received Message: " + message);
    }

    @JmsListener(destination = "notificacion")
    public void Consoleconsumer(String message) {

        System.out.println("consumer  Received Message: " + message);
    }

}
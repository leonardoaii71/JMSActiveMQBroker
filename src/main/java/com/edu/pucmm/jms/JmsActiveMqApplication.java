package com.edu.pucmm.jms;

import com.pusher.rest.Pusher;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.Queue;
import java.util.Collections;

@SpringBootApplication
public class JmsActiveMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsActiveMqApplication.class, args);
        try {
            //Subiendo la versión embedded de ActiveMQ.
            //http://activemq.apache.org/how-do-i-embed-a-broker-inside-a-connection.html
            BrokerService broker = new BrokerService();
            //configurando el broker.
            broker.addConnector("tcp://0.0.0.0:61616");
            //Inicializando
            broker.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    Pusher pusherConnection() {
        Pusher pusher = new Pusher("104g845", "30fdfgdfgxc90039031a", "a1543ggfgd2cd09af695");
        pusher.setCluster("us2");
        pusher.setEncrypted(true);
        return pusher;
    }
}

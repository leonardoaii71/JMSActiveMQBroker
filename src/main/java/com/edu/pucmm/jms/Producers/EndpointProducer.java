package com.edu.pucmm.jms.Producers;
import com.edu.pucmm.jms.Email;

import com.edu.pucmm.jms.EndPointMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pusher.rest.Pusher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Collections;


@RestController
@RequestMapping("/rest/publish")
public class EndpointProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Pusher pushat;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String message) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        LocalDateTime date = LocalDateTime.now();

        try {
            String result = mapper.writeValueAsString(date);
            EndPointMessage emessage = new EndPointMessage(result, 1, 9.3f, 5.5f);

            jmsTemplate.convertAndSend("notificacion_sensores", emessage);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Published Successfully";
    }


}

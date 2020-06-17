package com.leg.kafkatest;


import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class KafkaProducer {

    private static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static List<Flight> flights = FileRead.flight();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();;

    //发送消息方法
    public void send() {
        for(int i=0;i<8;i++){
            Random random = new Random();
            int i2 = random.nextInt(700);
            Flight flight = new Flight();
            flight = this.flights.get(i2);
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
            flight.setSendTime(df.format(day));
            logger.info("发送消息 ----->>>>>  message = {}", gson.toJson(flight));
            kafkaTemplate.send("hello", gson.toJson(flight));
        }
    }


}


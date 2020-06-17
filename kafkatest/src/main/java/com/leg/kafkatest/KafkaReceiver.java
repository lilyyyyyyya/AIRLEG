package com.leg.kafkatest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {

    private static Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);
    private String mes = "";
    private List<String> list = new ArrayList<String>();

    @KafkaListener(topics = {"hello"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            if (this.list.size()>=8){
                this.list.remove(0);
            }
            this.list.add(message.toString());
            System.out.println(message);
            logger.info("----------------- record =" + record);
            logger.info("------------------ message =" + message);
        }

    }

    public String getMes() {
        return mes;
    }

    public List<String> getList() {
        return list;
    }


}



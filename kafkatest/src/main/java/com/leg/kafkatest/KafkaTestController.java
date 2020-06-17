package com.leg.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class KafkaTestController {

    @Autowired
    private KafkaProducer producer;
    @Autowired
    private KafkaReceiver receiver;

    @RequestMapping("/testSendMsg")
    @ResponseBody
    public String testSendMsg(){
        producer.send();
        return "success";
    }

    @RequestMapping("/SendMsg")
    @ResponseBody
    public List<String> SendMsg(){
        producer.send();
        return receiver.getList();
    }



}


package com.gfg.jbdl12kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
    @Autowired
    private KafkaManager kafkaManager;
    @PostMapping("/message")
    void post(@RequestBody Message message){
        kafkaManager.produce(message);
    }
}

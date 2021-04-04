package com.gfg.jbdl12kafkademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaManagerImpl implements KafkaManager{
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;
    @Override
    public void produce(Message message) {
        kafkaTemplate.send(message.getTopic(),message.getMessage());
    }

    @Override
    @KafkaListener(topics = "test", groupId = "app")
    public void consume(String message) {
        log.info("message received");
        log.info("message is {}", message);
    }
}

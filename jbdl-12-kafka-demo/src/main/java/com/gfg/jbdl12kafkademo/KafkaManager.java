package com.gfg.jbdl12kafkademo;

public interface KafkaManager {
    void produce(Message message);
    void consume(String message);
}

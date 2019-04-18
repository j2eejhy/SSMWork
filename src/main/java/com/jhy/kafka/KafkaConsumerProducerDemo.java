package com.jhy.kafka;

/**
 * @Auther: admin
 * @Date: 2018/8/13 15:50
 * @Description:
 */
public class KafkaConsumerProducerDemo {
    public static void main(String[] args)
    {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
        producerThread.start();
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }
}

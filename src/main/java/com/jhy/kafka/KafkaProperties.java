package com.jhy.kafka;

/**
 * @Auther: admin
 * @Date: 2018/8/13 15:47
 * @Description:
 */
public interface KafkaProperties {
    final static String zkConnect = "47.106.143.28:2181";
    final static String groupId = "group1";
    final static String topic = "topic1";
    final static String kafkaServerURL = "47.106.143.28";
    final static int kafkaServerPort = 9092;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";
}

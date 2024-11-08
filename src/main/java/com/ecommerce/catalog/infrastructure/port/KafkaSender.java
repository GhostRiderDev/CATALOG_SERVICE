package com.ecommerce.catalog.infrastructure.port;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
  
  private final KafkaTemplate<String, Object> kafkaTemplate;
  
  public KafkaSender(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }
  
  public void send(String topic, Object message) {
    kafkaTemplate.send(topic, message);
  }
}

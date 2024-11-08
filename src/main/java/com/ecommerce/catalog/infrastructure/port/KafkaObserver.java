package com.ecommerce.catalog.infrastructure.port;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaObserver {
  
  @KafkaListener(topics = "alguma-coisa", groupId = "catalog")
  public void listen(Object message) {
    System.out.println("Received Message in group catalog: " + message);
  }
}

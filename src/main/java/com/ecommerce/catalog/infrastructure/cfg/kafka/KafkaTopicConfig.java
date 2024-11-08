package com.ecommerce.catalog.infrastructure.cfg.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
  @Bean
  public NewTopic catalogTopic() {
    return TopicBuilder.name("catalog.product-check").partitions(1).replicas(1).build();
  }
  
}

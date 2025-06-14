// package com.notification.configuration;

// import org.apache.kafka.clients.consumer.ConsumerConfig;
// import org.apache.kafka.common.serialization.StringDeserializer;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.annotation.EnableKafka;
// import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
// import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

// import java.util.HashMap;
// import java.util.Map;

// @EnableKafka
// @Configuration
// public class KafkaConsumerConfig {

//     @Bean
//     public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//         ConcurrentKafkaListenerContainerFactory<String, String> factory =
//                 new ConcurrentKafkaListenerContainerFactory<>();
//         factory.setConsumerFactory(consumerFactory());
//         return factory;
//     }

//     @Bean
//     public DefaultKafkaConsumerFactory<String, String> consumerFactory() {
//         return new DefaultKafkaConsumerFactory<>(consumerConfigs());
//     }

//     @Bean
//     public Map<String, Object> consumerConfigs() {
//         Map<String, Object> props = new HashMap<>();
//         props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//         props.put(ConsumerConfig.GROUP_ID_CONFIG, "notification-service-group");
//         props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//         props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//         props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//         return props;
//     }
// }

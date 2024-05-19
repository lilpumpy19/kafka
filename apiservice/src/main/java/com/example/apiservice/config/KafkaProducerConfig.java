package com.example.apiservice.config;

import com.example.apiservice.dto.StudentDTO;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public NewTopic studentsTopic(){
        return new NewTopic("studentsTopic", 1, (short) 1);
    }
    @Bean
    public ProducerFactory<String, StudentDTO> producerFactory(){
        Map<String, Object> configMap = new HashMap();
        configMap.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServer);
        configMap.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configMap.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaProducerFactory<>(configMap);
    }

    @Bean
    public KafkaTemplate<String,StudentDTO> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}

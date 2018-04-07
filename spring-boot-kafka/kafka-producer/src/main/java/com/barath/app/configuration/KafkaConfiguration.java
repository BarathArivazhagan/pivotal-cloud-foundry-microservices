package com.barath.app.configuration;

import com.barath.app.model.Customer;
import com.barath.app.model.Order;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfiguration {

    private final KafkaProperties properties;

    public KafkaConfiguration(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public KafkaTemplate<Object,Object> jsonKafkaTemplate() {
        KafkaTemplate<Object,Object> kafkaTemplate = new KafkaTemplate(jsonProducerFactory());
        kafkaTemplate.setProducerListener(producerListener());
        kafkaTemplate.setDefaultTopic(this.properties.getTemplate().getDefaultTopic());
        return kafkaTemplate;
    }



    @Bean
    public ProducerListener<Object,Object> producerListener() {
        return new LoggingProducerListener();
    }

    @Bean
    public ConsumerFactory<?, ?> kafkaConsumerFactory() {
        return new DefaultKafkaConsumerFactory(this.properties.buildConsumerProperties());
    }

    @Bean
    public ProducerFactory<?, ?> jsonProducerFactory() {

        return new DefaultKafkaProducerFactory(this.properties.buildProducerProperties(),new LongSerializer(),new JsonSerializer());
    }




}

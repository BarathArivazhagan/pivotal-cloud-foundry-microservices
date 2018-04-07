package com.barath.app.configuration;


import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.barath.app.model.Customer;
import com.barath.app.model.Order;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryContext;

@Configuration
public class KafkaConfiguration {
	
	private final KafkaProperties properties;	
	

	public KafkaConfiguration(KafkaProperties properties) {
		super();
		this.properties = properties;
	}


	@Bean
	public ConcurrentKafkaListenerContainerFactory customerContainerFactory(){

		ConcurrentKafkaListenerContainerFactory factory=new ConcurrentKafkaListenerContainerFactory();
		factory.setConsumerFactory(customerConsumerFactory());
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory orderContainerFactory(){

		ConcurrentKafkaListenerContainerFactory factory=new ConcurrentKafkaListenerContainerFactory();
		factory.setConsumerFactory(orderConsumerFactory());
		return factory;
	}


	@Bean(name = "kafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory defaultContainerFactory(){

		ConcurrentKafkaListenerContainerFactory factory=new ConcurrentKafkaListenerContainerFactory();
		factory.setConsumerFactory(defaultConsumerFactory());
		return factory;
	}




	@Bean
	public ConsumerFactory<Long,Customer> customerConsumerFactory() {
	    return new DefaultKafkaConsumerFactory<Long,Customer>(properties.buildConsumerProperties(), new LongDeserializer(), new JsonDeserializer(Customer.class));
	}

	@Bean
	public ConsumerFactory<Long,Order> orderConsumerFactory() {
		return new DefaultKafkaConsumerFactory<Long,Order>(properties.buildConsumerProperties(), new LongDeserializer(), new JsonDeserializer(Order.class));
	}

	@Bean
	public ConsumerFactory defaultConsumerFactory() {
		return new DefaultKafkaConsumerFactory<String,String>(properties.buildConsumerProperties(), new StringDeserializer(), new StringDeserializer());
	}






}

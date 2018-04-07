package com.barath.app.listener;

import com.barath.app.event.CustomerSaveEvent;
import com.barath.app.kafka.publisher.PublisherService;

import com.barath.app.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


import java.lang.invoke.MethodHandles;

@Component
public class CustomerSaveEventListener implements ApplicationListener<CustomerSaveEvent> {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private PublisherService publisherService;

    @Value("${kafka.topics.customer}")
    private String customerTopic;

    public CustomerSaveEventListener(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Override
    public void onApplicationEvent(CustomerSaveEvent customerSaveEvent) {

        Customer customer=(Customer)customerSaveEvent.getSource();
        if(logger.isInfoEnabled()) logger.info("publishing to kafka with source {}",customer);
        publisherService.publish(customerTopic,customer);

    }
}

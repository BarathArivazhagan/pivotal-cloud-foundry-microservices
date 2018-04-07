package com.barath.app.listener;

import com.barath.app.event.CustomerSaveEvent;
import com.barath.app.event.OrderPlaceEvent;
import com.barath.app.kafka.publisher.PublisherService;
import com.barath.app.model.Customer;
import com.barath.app.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;


@Component
public class OrderPlaceEventListener implements ApplicationListener<OrderPlaceEvent> {
        private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
        private PublisherService publisherService;

        @Value("${kafka.topics.order}")
        private String orderTopic;

        public OrderPlaceEventListener(PublisherService publisherService) {
            this.publisherService = publisherService;
        }

        @Override
        public void onApplicationEvent(OrderPlaceEvent orderPlaceEvent) {

            Order order = (Order) orderPlaceEvent.getSource();
            if (logger.isInfoEnabled()) logger.info("publishing to kafka with message source {}", order);
            publisherService.publish(orderTopic, order);
        }
}

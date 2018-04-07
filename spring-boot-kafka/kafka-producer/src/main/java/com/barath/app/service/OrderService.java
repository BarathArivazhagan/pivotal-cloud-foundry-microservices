package com.barath.app.service;

import com.barath.app.event.OrderPlaceEvent;
import com.barath.app.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

@Service
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public OrderService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Order placeOrder(Optional<Order> orderOptional){

        if(!orderOptional.isPresent()) throw new RuntimeException("Bad request");
        final Order order=orderOptional.get();
        if(logger.isInfoEnabled()) logger.info("order with details {} ",order);
        eventPublisher.publishEvent(new OrderPlaceEvent(order));
        return order;
    }
}

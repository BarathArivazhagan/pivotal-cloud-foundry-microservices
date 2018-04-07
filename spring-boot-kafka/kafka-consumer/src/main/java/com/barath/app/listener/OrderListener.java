package com.barath.app.listener;

import com.barath.app.model.Customer;
import com.barath.app.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class OrderListener {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @KafkaListener(topics= "${kafka.topics.order}",containerFactory = "orderContainerFactory")
    public void handlePlaceOrder(Order order){

        if(logger.isInfoEnabled()) logger.info("kafka listener received order to be saved {} ",order);

    }
}

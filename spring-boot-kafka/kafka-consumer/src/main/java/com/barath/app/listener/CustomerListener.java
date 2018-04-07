package com.barath.app.listener;


import com.barath.app.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class CustomerListener {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @KafkaListener(topics= "${kafka.topics.customer}",containerFactory ="customerContainerFactory" )
    public void handleCustomerSave(Customer customer){

       if(logger.isInfoEnabled()) logger.info("kafka listener received customer to be saved {} ",customer);
       
    }
}

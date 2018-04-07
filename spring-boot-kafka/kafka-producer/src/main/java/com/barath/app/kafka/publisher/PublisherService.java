package com.barath.app.kafka.publisher;

import com.barath.app.model.Customer;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;


public interface PublisherService {

   ListenableFuture<SendResult<Object,Object>> publish(Object object);

   ListenableFuture<SendResult<Object,Object>> publish(String topicName, Object object);
}

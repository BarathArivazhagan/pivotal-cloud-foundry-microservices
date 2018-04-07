package com.barath.app.kafka.publisher;

import com.barath.app.model.Customer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaPublisherService implements PublisherService {

    private final KafkaTemplate<Object,Object> kafkaTemplate;
    private final KafkaCallbackHandler kafkaCallbackHandler;

    public KafkaPublisherService(KafkaTemplate<Object,Object> kafkaTemplate,KafkaCallbackHandler kafkaCallbackHandler) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaCallbackHandler=kafkaCallbackHandler;
    }

    @Override
    public ListenableFuture<SendResult<Object,Object>> publish(Object object) {

        return kafkaTemplate.sendDefault(object);

    }

    @Override
    public ListenableFuture<SendResult<Object,Object>> publish(String topicName,Object object) {

        ListenableFuture<SendResult<Object,Object>> future=null;
        if(StringUtils.isEmpty(topicName)) {
            future=publish(object);
        }else{
            future=kafkaTemplate.send(topicName,object);
        }

        future.addCallback(kafkaCallbackHandler);
        return future;
    }

}

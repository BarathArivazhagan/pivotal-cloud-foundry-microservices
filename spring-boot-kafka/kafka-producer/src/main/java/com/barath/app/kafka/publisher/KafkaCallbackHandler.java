package com.barath.app.kafka.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.lang.invoke.MethodHandles;

@Component
public class KafkaCallbackHandler implements ListenableFutureCallback<SendResult<Object,Object>> {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void onSuccess(SendResult<Object, Object> sendResult) {

        logger.info(" message sent to kafka topic successfully {}",sendResult);
    }

    @Override
    public void onFailure(Throwable throwable) {

        logger.error("kafka error {}",throwable.getMessage());
    }
}

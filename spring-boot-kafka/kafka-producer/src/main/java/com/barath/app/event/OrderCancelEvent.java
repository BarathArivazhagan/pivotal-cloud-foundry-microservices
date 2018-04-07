package com.barath.app.event;

import org.springframework.context.ApplicationEvent;

public class OrderCancelEvent  extends ApplicationEvent {

    public OrderCancelEvent(Object source) {
        super(source);
    }
}

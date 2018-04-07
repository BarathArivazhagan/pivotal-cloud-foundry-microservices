package com.barath.app.event;

import org.springframework.context.ApplicationEvent;

public class OrderPlaceEvent  extends ApplicationEvent  {

    public OrderPlaceEvent(Object source) {
        super(source);
    }


}

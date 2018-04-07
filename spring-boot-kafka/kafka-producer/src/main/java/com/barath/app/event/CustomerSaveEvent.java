package com.barath.app.event;

import org.springframework.context.ApplicationEvent;

public class CustomerSaveEvent extends ApplicationEvent {

	private static final long serialVersionUID = -6552874517770133570L;

	public CustomerSaveEvent(Object source) {
        super(source);
    }
}

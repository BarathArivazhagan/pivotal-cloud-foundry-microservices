package com.barath.app.controller;


import com.barath.app.model.Order;
import com.barath.app.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService=orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Optional<Order> orderOptional){

        if(logger.isInfoEnabled()) logger.info(" request for new order ");
        return this.orderService.placeOrder(orderOptional);
    }
}

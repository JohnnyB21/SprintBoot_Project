package com.promineotech.jeep.jeepsales;

import com.promineotech.jeep.Order;
import com.promineotech.jeep.OrderRequest;
import com.promineotech.jeep.jeepsales.service.JeepOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicJeepOrderController implements JeepOrderController{
    @Autowired
    private JeepOrderService jeepOrderService;

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        log.debug("Order={}", orderRequest);
        return jeepOrderService.createOrder(orderRequest);
    }
    
}

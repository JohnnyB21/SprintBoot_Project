package com.promineotech.jeep.jeepsales.service;

import com.promineotech.jeep.Order;
import com.promineotech.jeep.OrderRequest;

public interface JeepOrderService {

    Order createOrder(OrderRequest orderRequest);
    
}

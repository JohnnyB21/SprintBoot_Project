package com.promineotech.jeep.jeepsales.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import com.promineotech.jeep.Color;
import com.promineotech.jeep.Customer;
import com.promineotech.jeep.Engine;
import com.promineotech.jeep.Option;
import com.promineotech.jeep.Order;
import com.promineotech.jeep.OrderRequest;
import com.promineotech.jeep.Tire;
import com.promineotech.jeep.DAO.JeepOrderDao;
import com.promineotech.jeep.jeepsales.Jeep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultJeepOrderService implements JeepOrderService {
    @Autowired
    private JeepOrderDao jeepOrderDao;

    @Transactional
    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Customer customer = getCustomer(orderRequest);
        Jeep jeep = getModel(orderRequest);
        Color color = getColor(orderRequest);
        Engine engine = getEngine(orderRequest);
        Tire tire = getTire(orderRequest);
        List<Option> options = getOption(orderRequest);

        BigDecimal price = jeep.getBasePrice().add(color.getPrice())
                            .add(engine.getPrice()).add(tire.getPrice());
        for(Option option : options){
           price = price.add(option.getPrice());
        }
        
        return jeepOrderDao.saveOrder(customer, jeep, color, engine, tire, price, options);
        }

    private List<Option> getOption(OrderRequest orderRequest) {
        return jeepOrderDao.fetchOptions(orderRequest.getOptions());
    }

    private Tire getTire(OrderRequest orderRequest) {
        return jeepOrderDao.fetchTire(orderRequest.getTire()).orElseThrow(
            () -> new NoSuchElementException("Tire with ID=" + orderRequest.getTire() + " was not found"));
    }

    private Engine getEngine(OrderRequest orderRequest) {
        return jeepOrderDao.fetchEngine(orderRequest.getEngine()).orElseThrow(
            () -> new NoSuchElementException("Engine with ID=" + orderRequest.getEngine() + " was not found"));
    }

    private Color getColor(OrderRequest orderRequest) {
        return jeepOrderDao.fetchColor(orderRequest.getColor()).orElseThrow(
            () -> new NoSuchElementException("Color with ID=" + orderRequest.getColor() + " was not found"));
    }

    private Jeep getModel(OrderRequest orderRequest) {
        return jeepOrderDao.fetchModel(orderRequest.getModel(), orderRequest.getTrim(),
                        orderRequest.getDoors()).orElseThrow(() -> new NoSuchElementException(
                            "Model with ID=" + orderRequest.getModel() + " trim=" + orderRequest.getTrim() +
                                orderRequest.getDoors() + " was not found"));
    }

    private Customer getCustomer(OrderRequest orderRequest) {
        return jeepOrderDao.fetchCustomer(orderRequest.getCustomer())
            .orElseThrow(() -> new NoSuchElementException("Customer with ID=" 
                 + orderRequest.getCustomer() + " was not found"));
    }
    
}

package com.promineotech.jeep.jeepsales;

import java.util.List;

import com.promineotech.JeepModel;
import com.promineotech.jeep.jeepsales.service.JeepSalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class BasicJeepSalesController implements JeepSalesController{

    @Autowired 
    private JeepSalesService jeepSalesService;

    @Override
    public List<Jeep> fetchJeeps(JeepModel model, String trim) {
        log.debug("model = {}, trim = {}", model, trim);
        return jeepSalesService.fetchJeeps(model, trim);
    }
    
}

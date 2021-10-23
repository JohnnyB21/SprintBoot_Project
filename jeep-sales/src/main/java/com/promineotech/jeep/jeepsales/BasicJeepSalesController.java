package com.promineotech.jeep.jeepsales;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
@RestController
public class BasicJeepSalesController implements JeepSalesController{

    @Override
    public List<Jeep> fetchJeeps(String model, String trim) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

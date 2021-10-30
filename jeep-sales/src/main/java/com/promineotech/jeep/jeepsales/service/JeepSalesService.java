package com.promineotech.jeep.jeepsales.service;

import java.util.List;

import com.promineotech.jeep.jeepsales.Jeep;

public interface JeepSalesService {

    List<Jeep> fetchJeeps(String model, String trim);
    
}

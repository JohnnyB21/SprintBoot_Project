package com.promineotech.jeep.DAO;

import java.util.List;

import com.promineotech.JeepModel;
import com.promineotech.jeep.jeepsales.Jeep;

public interface JeepSalesDao {
    /**
     * 
     * @param model
     * @param trim
     * @return
     */
    List<Jeep> fetchJeeps(JeepModel model, String trim);
    
}

package com.promineotech.jeep.jeepsales.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import com.promineotech.JeepModel;
import com.promineotech.jeep.DAO.JeepSalesDao;
import com.promineotech.jeep.jeepsales.Jeep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultJeepSalesService implements JeepSalesService{

    @Autowired 
    private JeepSalesDao jeepSalesDao;

    @Transactional(readOnly = true)
    @Override
    public List<Jeep> fetchJeeps(JeepModel model, String trim) {
        log.info("The fetchJeeps method was called with model={} and trim={}", 
        model, trim);

        List<Jeep> jeeps = jeepSalesDao.fetchJeeps(model, trim);

        if(jeeps.isEmpty()){
            String msg = String.format(
                "No jeeps found with model=%s and trim=%s", model, trim);

                throw new NoSuchElementException(msg);   
                 }
                 
        Collections.sort(jeeps);
        return jeeps;
    }
    
}

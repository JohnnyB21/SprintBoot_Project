package com.promineotech.jeep.DAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;



import com.promineotech.JeepModel;
import com.promineotech.jeep.Color;
import com.promineotech.jeep.Customer;
import com.promineotech.jeep.Engine;
import com.promineotech.jeep.Option;
import com.promineotech.jeep.Order;
import com.promineotech.jeep.Tire;
import com.promineotech.jeep.jeepsales.Jeep;



public interface JeepOrderDao {

    Optional<Customer> fetchCustomer(String customer);

    Optional<Jeep> fetchModel(JeepModel model, String trim, int doors);

    Optional<Color> fetchColor(String color);

    Optional<Engine> fetchEngine(String engine);

    Optional<Tire> fetchTire(String tire);

    Order saveOrder(Customer customer, Jeep jeep, Color color, Engine engine, Tire tire, BigDecimal price, List<Option> options);

    List<Option> fetchOptions(List< String> optionIds);

   
    
}

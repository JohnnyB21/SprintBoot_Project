package com.promineotech.jeep;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.jeep.jeepsales.Jeep;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Order {
   private Long orderPk;
   private Customer customer;
   private Jeep model;
   private Color color;
   private Engine engine;
   private Tire tire;
   private List<Option> options;
   private BigDecimal price;

   @JsonIgnore
   public Long getOrderPk() {
      return orderPk;
   }
   



   

}

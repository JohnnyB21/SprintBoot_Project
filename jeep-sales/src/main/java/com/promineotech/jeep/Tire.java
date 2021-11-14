package com.promineotech.jeep;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tire {
   private Long tirePk;
   private String tireId;
   private String tireSize;
   private String manufacturer;
   private BigDecimal price;
   private int warrantyMiles;


}

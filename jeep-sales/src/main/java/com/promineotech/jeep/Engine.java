package com.promineotech.jeep;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Engine {
    private Long enginePk;
    private String engineId;
    private float sizeInLiters;
    private String name;
    private FuelType fuelType;
    private Float mpgCity;
    private Float mpgHwy;
    private boolean hasStartStop;
    private String description;
    private BigDecimal price;
}

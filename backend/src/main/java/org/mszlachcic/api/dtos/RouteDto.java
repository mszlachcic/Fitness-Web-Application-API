package org.mszlachcic.api.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RouteDto {

    private String name;
    private BigDecimal distance;
    private CityDto city;
    private LocalDateTime date;
}
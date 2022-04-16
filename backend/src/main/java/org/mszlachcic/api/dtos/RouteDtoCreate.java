package org.mszlachcic.api.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RouteDtoCreate {

    private String name;
    private BigDecimal distance;
    private CityDto city;
    private LocalDateTime date;
    private List<CheckpointDto> checkpointList;
}

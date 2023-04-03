package org.mszlachcic.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RouteDtoCreate {

    private String name;
    private BigDecimal distance;
    private AddressDto address;
    private LocalDateTime date;
    private List<CheckpointDto> checkpointList;
}

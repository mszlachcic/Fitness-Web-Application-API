package org.mszlachcic.api.route;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.address.AddressDto;
import org.mszlachcic.api.checkpoint.CheckpointDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RouteWithCheckpointsDto {

    private String name;
    private BigDecimal distance;
    private AddressDto address;
    private LocalDateTime date;
    private List<CheckpointDto> checkpointList;
}

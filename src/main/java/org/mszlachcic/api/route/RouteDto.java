package org.mszlachcic.api.route;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.address.AddressDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class RouteDto {
    private String name;
    private BigDecimal distance;
    private AddressDto address;
    private LocalDateTime date;
}

package org.mszlachcic.api.dtos;

import lombok.Data;

@Data
public class CityDto {
    private Long id;
    private String name;
    private CountryDto country;
}

package org.mszlachcic.api.dtos;

import lombok.Data;

@Data
public class CityResponseDto {
    private String name;
    private CountryDto country;
}

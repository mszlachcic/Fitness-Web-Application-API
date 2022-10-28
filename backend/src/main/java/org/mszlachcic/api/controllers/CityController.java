package org.mszlachcic.api.controllers;

import org.mszlachcic.api.dtos.CityResponseDto;
import org.mszlachcic.api.services.CityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getCities")
    public List<CityResponseDto> getCities(){
        return cityService.getCities();
    }
}

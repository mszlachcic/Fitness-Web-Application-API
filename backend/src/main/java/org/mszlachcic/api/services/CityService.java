package org.mszlachcic.api.services;

import org.modelmapper.ModelMapper;
import org.mszlachcic.api.dtos.CityResponseDto;
import org.mszlachcic.api.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityResponseDto> getCities(){
        List<CityResponseDto> returnList;
        returnList = cityRepository.findCitiesByIdLessThan(new Long(19))
                .stream()
                .map(g -> modelMapper.map(g, CityResponseDto.class))
                .collect(Collectors.toList());

        return returnList;
    }
}

package org.mszlachcic.api.services;

import org.mszlachcic.api.dtos.RouteDto;
import org.mszlachcic.api.dtos.RouteDtoCreate;
import org.mszlachcic.api.dtos.RouteWithCheckpointsDto;
import org.mszlachcic.api.entities.Checkpoint;
import org.mszlachcic.api.entities.City;
import org.mszlachcic.api.entities.Country;
import org.mszlachcic.api.entities.Route;
import org.mszlachcic.api.repository.CheckpointRepository;
import org.mszlachcic.api.repository.CityRepository;
import org.mszlachcic.api.repository.CountryRepository;
import org.mszlachcic.api.repository.RouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final CheckpointRepository checkpointRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public RouteService(RouteRepository routeRepository, CheckpointRepository checkpointRepository, CountryRepository countryRepository, CityRepository cityRepository) {
        this.routeRepository = routeRepository;
        this.checkpointRepository = checkpointRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public List<RouteDto> getAllRoutes(){
        List<RouteDto>routeList = routeRepository
                .findAll()
                .stream()
                .map(route -> modelMapper.map(route, RouteDto.class))
                .collect(Collectors.toList());
        return routeList;
    }

    public List<RouteDto> getRoutesByCityName(String name){
        List<RouteDto> routeDtoList = routeRepository
                .findAllByCity_Name(name)
                .stream()
                .map(route -> modelMapper.map(route,RouteDto.class))
                .collect(Collectors.toList());
        return routeDtoList;
    }

    public void createRoute(RouteDtoCreate routeDtoCreate){
//        List<CheckpointDto> checkpointDtoList = routeDtoCreate.getCheckpointList();
        Route route = modelMapper.map(routeDtoCreate,Route.class);
        List<Checkpoint> checkpointList = route.getCheckpointList();
        City city = route.getCity();
        Country country = city.getCountry();

        countryRepository.save(country);
        cityRepository.save(city);

                for (Checkpoint checkpoint: checkpointList) {
            checkpoint.setRoute(route);
        }


        routeRepository.save(route);


//        checkpointList = checkpointDtoList
//                .stream()
//                .map(dto -> modelMapper.map(dto,Checkpoint.class))
//                .collect(Collectors.toList());


//
//        for (Checkpoint checkpoint: checkpointList) {
//            checkpoint.setRoute(null);
//        }
//        checkpointRepository.saveAll(checkpointList);
//        routeRepository.save(route);
    }

    public RouteWithCheckpointsDto getRouteByName(String name){
        Route route = routeRepository.findByName(name);
        RouteWithCheckpointsDto routeDto = modelMapper.map(route,RouteWithCheckpointsDto.class);
        return routeDto;
    }
}

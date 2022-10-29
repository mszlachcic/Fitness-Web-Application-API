package org.mszlachcic.api.services;

import org.mszlachcic.api.dtos.RouteDto;
import org.mszlachcic.api.dtos.RouteDtoCreate;
import org.mszlachcic.api.dtos.RouteWithCheckpointsDto;
import org.mszlachcic.api.entities.Address;
import org.mszlachcic.api.entities.Checkpoint;
import org.mszlachcic.api.entities.Route;
import org.mszlachcic.api.repository.AddressRepository;
import org.mszlachcic.api.repository.CheckpointRepository;
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
    private final AddressRepository addressRepository;

    public RouteService(RouteRepository routeRepository,
                        CheckpointRepository checkpointRepository,
                        AddressRepository addressRepository) {
        this.routeRepository = routeRepository;
        this.checkpointRepository = checkpointRepository;
        this.addressRepository = addressRepository;
    }

    public List<RouteDto> getAllRoutes(){
        List<RouteDto>routeList = routeRepository
                .findAll()
                .stream()
                .map(route -> modelMapper.map(route, RouteDto.class))
                .collect(Collectors.toList());
        return routeList;
    }

    public void createRoute(RouteDtoCreate routeDtoCreate){
        Route route = modelMapper.map(routeDtoCreate,Route.class);
        List<Checkpoint> checkpointList = route.getCheckpointList();
        Address address = route.getAddress();

        addressRepository.save(address);
            for (Checkpoint checkpoint: checkpointList)
                checkpoint.setRoute(route);

        routeRepository.save(route);
    }

    public RouteWithCheckpointsDto getRouteByName(String name){
        Route route = routeRepository.findByName(name);
        RouteWithCheckpointsDto routeDto = modelMapper.map(route,RouteWithCheckpointsDto.class);
        return routeDto;
    }
}

package org.mszlachcic.api.route;

import org.mszlachcic.api.address.Address;
import org.mszlachcic.api.checkpoint.Checkpoint;
import org.mszlachcic.api.address.AddressRepository;
import org.mszlachcic.api.checkpoint.CheckpointRepository;
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

    public List<RouteWithCheckpointsDto> getRoutesByCityName(String name){
        List<Route> routeList = routeRepository.getRoutesByCityName(name);

        return routeList
                .stream()
                .map(r -> modelMapper.map(r, RouteWithCheckpointsDto.class))
                .collect(Collectors.toList());
    }
}

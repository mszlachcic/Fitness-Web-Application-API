package org.mszlachcic.api.controllers;

import org.mszlachcic.api.dtos.RouteDto;
import org.mszlachcic.api.dtos.RouteDtoCreate;
import org.mszlachcic.api.dtos.RouteWithCheckpointsDto;
import org.mszlachcic.api.services.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping(value = "/getAllRoutes")
    public List<RouteDto> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @GetMapping(value = "/getRoutesByCityName")
    public List<RouteDto> getRoutesByCityName(@RequestParam String name){
        return routeService.getRoutesByCityName(name);
    }

    @PostMapping(value = "/createRoute")
    public void createRoute(@RequestBody RouteDtoCreate routeDtoCreate){
        routeService.createRoute(routeDtoCreate);
    }

    @GetMapping(value = "/getRouteByName")
    public RouteWithCheckpointsDto getRouteByName(@RequestParam String name){
        return routeService.getRouteByName(name);
    }
}
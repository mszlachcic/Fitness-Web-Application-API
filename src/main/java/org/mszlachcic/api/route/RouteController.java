package org.mszlachcic.api.route;

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


    @PostMapping(value = "/createRoute")
    public void createRoute(@RequestBody RouteDtoCreate routeDtoCreate){
        routeService.createRoute(routeDtoCreate);
    }

    @GetMapping(value = "/getRouteByName")
    public RouteWithCheckpointsDto getRouteByName(@RequestParam String name){
        return routeService.getRouteByName(name);
    }

    @GetMapping(value = "/getRoutesByCityName")
    public List<RouteWithCheckpointsDto> getRoutesByCityName(@RequestParam String name){
        return routeService.getRoutesByCityName(name);
    }

}

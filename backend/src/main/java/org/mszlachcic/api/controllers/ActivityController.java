package org.mszlachcic.api.controllers;

import org.mszlachcic.api.dtos.ActivityDto;
import org.mszlachcic.api.services.ActivityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/getAllActivities")
    public List<ActivityDto> getAllActivities(){
        return activityService.getAllActivities();
    }


}

package org.mszlachcic.api.controllers;

import org.mszlachcic.api.dtos.GetWorkoutDto;
import org.mszlachcic.api.dtos.WorkoutDto;
import org.mszlachcic.api.services.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/getWorkoutByDate")
    public List<WorkoutDto> getWorkoutsByDate(){
        return new ArrayList<WorkoutDto>();
    }
    @PostMapping("/addWorkout")
    public void addWorkout(@RequestBody WorkoutDto workoutDto){
        workoutService.addWorkout(workoutDto);
    }
    @GetMapping("/getWorkoutsByUsername")
    public List<GetWorkoutDto> getWorkoutsByUsername(@RequestParam String username){
        return workoutService.getWorkoutsByUsername(username);
    }

}

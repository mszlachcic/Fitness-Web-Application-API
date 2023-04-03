package org.mszlachcic.api.controllers;

import org.mszlachcic.api.dtos.GoalDto;
import org.mszlachcic.api.services.GoalService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("/addGoal")
    public void addGoal(@RequestBody GoalDto goalDto, @RequestParam Long userId){
        goalService.addGoal(goalDto, userId);
    }

    @GetMapping("/getGoalById")
    public GoalDto getGoalById(@RequestParam Long id){
        return goalService.getGoalById(id);
    }
    @PutMapping("/editGoalById")
    public void editGoal(@RequestParam BigDecimal newValueProgress, @RequestParam Long id){
        goalService.editGoalById(newValueProgress,id);
    }
    @GetMapping("/getGoalsByUserId")
    public List<GoalDto> getGoalsByUserId(@RequestParam Long id) {
        return goalService.getGoalsByUserId(id);
    }

}

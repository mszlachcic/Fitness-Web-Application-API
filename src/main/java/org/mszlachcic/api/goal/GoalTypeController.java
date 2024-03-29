package org.mszlachcic.api.goal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/goalTypes")
class GoalTypeController {

    private final GoalTypeService goalTypeService;

    public GoalTypeController(GoalTypeService goalTypeService) {
        this.goalTypeService = goalTypeService;
    }

    @GetMapping("/getGoalTypes")
    public List<GoalTypeDto> getGoalTypes(){
        return goalTypeService.getGoalTypes();
    }
}

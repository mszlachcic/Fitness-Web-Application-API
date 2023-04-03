package org.mszlachcic.api.controllers;

import org.mszlachcic.api.dtos.GoalDto;
import org.mszlachcic.api.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getGoalsByUsername")
    public List<GoalDto> getGoalsByUsername(@RequestParam String username){
        return userService.getGoalsByUsername(username);
    }
}

package org.mszlachcic.api.user;

import org.mszlachcic.api.goal.GoalDto;
import org.mszlachcic.api.user.UserService;
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

package org.mszlachcic.api.services;

import org.mszlachcic.api.dtos.GoalDto;
import org.mszlachcic.api.entities.Goal;
import org.mszlachcic.api.entities.GoalType;
import org.mszlachcic.api.entities.User;
import org.mszlachcic.api.repository.GoalRepository;
import org.mszlachcic.api.repository.GoalTypeRepository;
import org.mszlachcic.api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class GoalService {
    private final GoalRepository goalRepository;
    private final GoalTypeRepository goalTypeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public GoalService(GoalRepository goalRepository, GoalTypeRepository goalTypeRepository, UserRepository userRepository) {
        this.goalRepository = goalRepository;
        this.goalTypeRepository = goalTypeRepository;
        this.userRepository = userRepository;
    }

    public void addGoal(GoalDto goalDto, Long userId){
        Goal goal = modelMapper.map(goalDto, Goal.class);
        GoalType goalType = goal.getGoalType();
        goalTypeRepository.save(goalType);
        User user = userRepository.findById(userId).get();
        goal.setUser(user);
        goalRepository.save(goal);
    }

    public GoalDto getGoalById(Long id){
        GoalDto goalDto;
        goalDto = modelMapper.map(goalRepository.findById(id).get(),GoalDto.class);
        return goalDto;
    }

    public void editGoalById(BigDecimal newProgessValue, Long id){
        Goal goal = goalRepository.findById(id).get();
        goal.setValueProgress(newProgessValue);
        goalRepository.save(goal);
    }
//    public void getUserGoalsByUsername(String username){
//        goalRepository.findAllBy
//    }
}

package org.mszlachcic.api.services;

import org.mszlachcic.api.dtos.GoalDto;
import org.mszlachcic.api.entities.Activity;
import org.mszlachcic.api.entities.Goal;
import org.mszlachcic.api.entities.GoalType;
import org.mszlachcic.api.entities.User;
import org.mszlachcic.api.repository.ActivityRepository;
import org.mszlachcic.api.repository.GoalRepository;
import org.mszlachcic.api.repository.GoalTypeRepository;
import org.mszlachcic.api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {
    private final GoalRepository goalRepository;
    private final GoalTypeRepository goalTypeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    private final ActivityRepository activityRepository;

    public GoalService(GoalRepository goalRepository, GoalTypeRepository goalTypeRepository, UserRepository userRepository, ActivityRepository activityRepository) {
        this.goalRepository = goalRepository;
        this.goalTypeRepository = goalTypeRepository;
        this.userRepository = userRepository;
        this.activityRepository = activityRepository;
    }

    public void addGoal(GoalDto goalDto, Long userId){
        Activity activity = activityRepository.findActivityByActivityName(goalDto.getActivity().getActivityName());
        GoalType goalType = goalTypeRepository.findGoalTypeByName(goalDto.getGoalType().getName());
        Goal goal = modelMapper.map(goalDto, Goal.class);
        User user = userRepository.findById(userId).get();

        goal.setUser(user);
        goal.setGoalType(goalType);
        goal.setActivity(activity);

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

    public List<GoalDto> getGoalsByUserId(Long id){
        List<Goal> goalList = goalRepository.findAllByUserId(id);


        return goalList
                .stream()
                .map(goal -> modelMapper.map(goal, GoalDto.class))
                .collect(Collectors.toList());
    }
//    public void getUserGoalsByUsername(String username){
//        goalRepository.findAllBy
//    }
}

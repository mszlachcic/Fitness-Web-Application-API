package org.mszlachcic.api.goal;

import org.mszlachcic.api.activity.Activity;
import org.mszlachcic.api.user.User;
import org.mszlachcic.api.activity.ActivityRepository;
import org.mszlachcic.api.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
class GoalService {
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

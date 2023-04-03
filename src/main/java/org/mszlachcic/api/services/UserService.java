package org.mszlachcic.api.services;

import org.mszlachcic.api.dtos.GoalDto;
import org.mszlachcic.api.entities.Goal;
import org.mszlachcic.api.repository.GoalRepository;
import org.mszlachcic.api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GoalRepository goalRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserService(UserRepository userRepository, GoalRepository goalRepository) {
        this.userRepository = userRepository;
        this.goalRepository = goalRepository;
    }

    public List<GoalDto> getGoalsByUsername(String username){
        List<Goal> goalList = goalRepository.findAllByUser_Username(username);

        List<GoalDto> goalDtoList;

        goalDtoList = goalList
                .stream()
                .map(g -> modelMapper.map(g, GoalDto.class))
                .collect(Collectors.toList());

        return goalDtoList;
    }
}

package org.mszlachcic.api.services;

import org.mszlachcic.api.dtos.GetWorkoutDto;
import org.mszlachcic.api.dtos.WorkoutDto;
import org.mszlachcic.api.entities.User;
import org.mszlachcic.api.entities.Workout;
import org.mszlachcic.api.repository.UserRepository;
import org.mszlachcic.api.repository.WorkoutRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
    }

    public void addWorkout(WorkoutDto workoutDto){
        String username = workoutDto.getUser().getUsername();
        User user = userRepository.findByUsername(username).get();

        Workout workout = modelMapper.map(workoutDto, Workout.class);
        workout.setUser(user);
        workoutRepository.save(workout);
    }

    public List<GetWorkoutDto> getWorkoutsByUsername(String username){
        List<GetWorkoutDto> workoutDtoList = workoutRepository.getWorkoutsByUserUsername(username)
                .stream()
                .map(workout -> modelMapper.map(workout,GetWorkoutDto.class))
                .collect(Collectors.toList());

        return workoutDtoList;
    }
}

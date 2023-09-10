package org.mszlachcic.api.workout;

import org.mszlachcic.api.activity.Activity;
import org.mszlachcic.api.route.Route;
import org.mszlachcic.api.user.User;
import org.mszlachcic.api.activity.ActivityRepository;
import org.mszlachcic.api.route.RouteRepository;
import org.mszlachcic.api.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final RouteRepository routeRepository;
    private final ActivityRepository activityRepository;

    public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository, RouteRepository routeRepository, ActivityRepository activityRepository) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.activityRepository = activityRepository;
    }
    public List<WorkoutDto> getWorkoutsBetweenDates(String startDate,
                                                    String endDate,
                                                    String username){
        return this.workoutRepository
                .getWorkoutsBetweenDates(LocalDateTime.parse(startDate),LocalDateTime.parse(endDate),username)
                .stream()
                .map(w -> (modelMapper.map(w, WorkoutDto.class)))
                .collect(Collectors.toList());
    }
    public void addWorkout(WorkoutDto workoutDto){
        String username = workoutDto.getUser().getUsername();
        User user = userRepository.findByUsername(username).get();
        Activity activity = activityRepository.findActivityByActivityName(workoutDto.getActivity().getActivityName());
        Route route = routeRepository.findByName(workoutDto.getRoute().getName());
        Workout workout = modelMapper.map(workoutDto, Workout.class);

        workout.setRoute(route);
        workout.setActivity(activity);
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
    public GetWorkoutDto getWorkoutById(Long id){
        Workout workout = workoutRepository.findWorkoutById(id);
        GetWorkoutDto getWorkoutDto = modelMapper.map(workout, GetWorkoutDto.class);
        return getWorkoutDto;
    }

    public List<GetWorkoutDto> get50MostRecentWorkoutsOfAllUsers(){
        return workoutRepository
                .get50MostRecentWorkoutsOfAllUsers()
                .stream()
                .map(w -> modelMapper.map(w,GetWorkoutDto.class))
                .collect(Collectors.toList());
    }
}

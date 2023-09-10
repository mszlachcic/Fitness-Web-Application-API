package org.mszlachcic.api.activity;


import org.modelmapper.ModelMapper;
import org.mszlachcic.api.activity.ActivityDto;
import org.mszlachcic.api.activity.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityDto> getAllActivities(){
        return activityRepository
                .findAll()
                .stream()
                .map(m-> modelMapper.map(m, ActivityDto.class))
                .collect(Collectors.toList());
    }
}

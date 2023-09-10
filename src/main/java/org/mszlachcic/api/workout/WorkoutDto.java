package org.mszlachcic.api.workout;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.activity.ActivityDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class WorkoutDto {
    private String title;
    private LocalDateTime start;
    private Long distance;
    private Long duration;
    private ActivityDto activity;
    private WorkoutUserCreateDto user;
    private WorkoutRouteCreateDto route;
}

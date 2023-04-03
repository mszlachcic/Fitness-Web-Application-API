package org.mszlachcic.api.dtos;

import lombok.Getter;
import lombok.Setter;

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

package org.mszlachcic.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GetWorkoutDto {
    private String title;
    private LocalDateTime start;
    private Long duration;
    private ActivityDto activity;
    private RouteDto route;
    private UserDto user;
}

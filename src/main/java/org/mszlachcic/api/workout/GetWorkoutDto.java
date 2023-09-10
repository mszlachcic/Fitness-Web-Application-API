package org.mszlachcic.api.workout;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.activity.ActivityDto;
import org.mszlachcic.api.user.UserDto;
import org.mszlachcic.api.route.RouteDto;

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

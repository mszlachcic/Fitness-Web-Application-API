package org.mszlachcic.api.workout;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.activity.EActivity;
import org.mszlachcic.api.user.UserDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class WorkoutCreateDto {
    private String title;
    private LocalDateTime start;
    private Long distance;
    private Long duration;
    private EActivity activity;
    private UserDto user;
}

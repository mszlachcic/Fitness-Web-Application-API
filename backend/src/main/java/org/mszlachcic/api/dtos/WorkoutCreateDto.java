package org.mszlachcic.api.dtos;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.enums.EActivity;

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

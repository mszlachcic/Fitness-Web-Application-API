package org.mszlachcic.api.dtos;

import org.mszlachcic.api.enums.EActivity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkoutDto {
    private String name;
    private LocalDateTime beginDate;
    private Long duration;
    private EActivity activity;
    private WorkoutUserCreateDto user;
}

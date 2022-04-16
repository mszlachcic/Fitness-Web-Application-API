package org.mszlachcic.api.dtos;

import org.mszlachcic.api.enums.EActivity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetWorkoutDto {
    private String name;
    private LocalDateTime beginDate;
    private Long duration;
    private EActivity activity;
}

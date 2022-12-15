package org.mszlachcic.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class GoalDto {
    private GoalTypeDto goalType;
    private BigDecimal valueToReach;
    private BigDecimal valueProgress;
    private ActivityDto activity;
    private LocalDateTime start;
    private Boolean recurring;
}

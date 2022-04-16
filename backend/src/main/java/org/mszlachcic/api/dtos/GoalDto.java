package org.mszlachcic.api.dtos;

import org.mszlachcic.api.enums.EGoalStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoalDto {
    private GoalTypeDto goalType;
    private BigDecimal valueToReach;
    private BigDecimal valueProgress;
    private EGoalStatus status;
}

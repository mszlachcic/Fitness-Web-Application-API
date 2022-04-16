package org.mszlachcic.api.entities;

import org.mszlachcic.api.enums.EGoalStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private GoalType goalType;
    private BigDecimal valueToReach;
    private BigDecimal valueProgress;
    private EGoalStatus status;
    @ManyToOne
    private User user;
}

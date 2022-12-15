package org.mszlachcic.api.entities;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.enums.EGoalStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private GoalType goalType;
    private BigDecimal valueToReach;
    private BigDecimal valueProgress;
    private LocalDateTime start;
    private Boolean recurring;
    @ManyToOne
    private User user;

    @ManyToOne
    private Activity activity;
}

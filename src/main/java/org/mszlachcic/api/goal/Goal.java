package org.mszlachcic.api.goal;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.activity.Activity;
import org.mszlachcic.api.user.User;

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

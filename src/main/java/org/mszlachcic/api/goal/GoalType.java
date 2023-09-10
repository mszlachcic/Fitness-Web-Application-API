package org.mszlachcic.api.goal;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.goal.Goal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
class GoalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "id")
    private List<Goal> goalList;
}

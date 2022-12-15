package org.mszlachcic.api.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activityName;
    @OneToMany(mappedBy = "activity",cascade=CascadeType.ALL)
    private List<Workout> workouts;

    @OneToMany(mappedBy = "activity",cascade = CascadeType.ALL)
    private List<Goal> goals;
}

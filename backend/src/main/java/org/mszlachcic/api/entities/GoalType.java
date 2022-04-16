package org.mszlachcic.api.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class GoalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String unit;
    @OneToMany(mappedBy = "id")
    private List<Goal> goalList;
}

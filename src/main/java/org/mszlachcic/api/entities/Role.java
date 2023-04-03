package org.mszlachcic.api.entities;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.enums.ERole;
import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
}

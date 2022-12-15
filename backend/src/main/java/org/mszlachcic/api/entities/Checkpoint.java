package org.mszlachcic.api.entities;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.enums.ECheckpointType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table
public class Checkpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(precision = 20,scale = 6)
    private BigDecimal latitude;
    @Column(precision = 20,scale = 6)
    private BigDecimal longitude;
    private ECheckpointType type;
    private Integer whichInTurn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    private Route route;
}

package org.mszlachcic.api.entities;

import org.mszlachcic.api.enums.ECheckpointType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table
public class Checkpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private ECheckpointType type;
    private Integer whichInTurn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    private Route route;
}

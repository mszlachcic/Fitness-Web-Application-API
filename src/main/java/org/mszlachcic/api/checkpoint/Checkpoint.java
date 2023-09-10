package org.mszlachcic.api.checkpoint;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.route.Route;

import javax.persistence.*;
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

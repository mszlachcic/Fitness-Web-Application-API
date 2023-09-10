package org.mszlachcic.api.checkpoint;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CheckpointDto {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private ECheckpointType type;
    private Integer whichInTurn;
}

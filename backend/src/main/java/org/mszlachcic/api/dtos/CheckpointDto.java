package org.mszlachcic.api.dtos;

import org.mszlachcic.api.enums.ECheckpointType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CheckpointDto {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private ECheckpointType type;
    private Integer whichInTurn;
}

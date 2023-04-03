package org.mszlachcic.api.dtos;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.enums.ECheckpointType;
import lombok.Data;

import java.math.BigDecimal;

@Getter
@Setter
public class CheckpointDto {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private ECheckpointType type;
    private Integer whichInTurn;
}

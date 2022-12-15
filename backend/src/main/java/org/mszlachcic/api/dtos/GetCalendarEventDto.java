package org.mszlachcic.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GetCalendarEventDto {
    private String title;
    private LocalDateTime start;
}

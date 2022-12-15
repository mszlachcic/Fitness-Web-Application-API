package org.mszlachcic.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PartyDto {
    private Long id;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime postDate;
    private RouteDtoCreate route;
    private List<UserDto> users;
}

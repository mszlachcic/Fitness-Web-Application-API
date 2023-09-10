package org.mszlachcic.api.party;

import lombok.Getter;
import lombok.Setter;
import org.mszlachcic.api.route.RouteDtoCreate;
import org.mszlachcic.api.user.UserDto;

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

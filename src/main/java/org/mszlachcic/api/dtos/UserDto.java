package org.mszlachcic.api.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String username;
    private String firstName;
    private String lastName;
}

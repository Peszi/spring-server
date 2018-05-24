package com.shutter.springserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO extends BasicUserDTO {
    private String email;
}

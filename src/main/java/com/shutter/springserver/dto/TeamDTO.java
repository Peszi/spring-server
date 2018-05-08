package com.shutter.springserver.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TeamDTO {
    private Long id;
    private String alias;
    private Set<BasicUserDTO> usersList;
}

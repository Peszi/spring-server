package com.shutter.springserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Deprecated
public class UserDTO {

    private int id;
    private String email;
    private String passwordHash;
    private boolean active;

}

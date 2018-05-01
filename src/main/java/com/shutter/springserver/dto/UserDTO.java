package com.shutter.springserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
public class UserDTO {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String nickname;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 6, max = 24)
    private String password;

}
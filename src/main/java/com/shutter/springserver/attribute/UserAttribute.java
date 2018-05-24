package com.shutter.springserver.attribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class UserAttribute {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String nickname;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 6, max = 20)
    private String password;

}

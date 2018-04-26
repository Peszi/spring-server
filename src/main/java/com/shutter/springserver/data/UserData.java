package com.shutter.springserver.data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserData extends User {

    private long id;

    public UserData(long id, String email, String password, boolean active, List<GrantedAuthority> authorities) {
        super(email, password, active, true, true, true, authorities);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

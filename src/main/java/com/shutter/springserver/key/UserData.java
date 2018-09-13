package com.shutter.springserver.key;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserData extends User {

    private int id;
    private String username;

    public UserData(int id, String username, String email, String password, boolean active, List<GrantedAuthority> authorities) {
        super(email, password, active, true, true, true, authorities);
        this.username = username;
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public int getId() {
        return id;
    }

}

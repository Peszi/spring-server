package com.shutter.springserver.model;

import lombok.ToString;

@ToString
public class UserDTO {

    private String email;
    private String passwordHash;
    private boolean active;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isActive() {
        return active;
    }
}

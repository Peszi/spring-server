package com.shutter.springserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private int id;
    private String email;
    private String password;
    private String token;
    private boolean active;
    private boolean deleted;

}

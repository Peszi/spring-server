package com.shutter.springserver.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.base.Objects;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String token;

    private boolean active;
    private boolean deleted;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
//    @JoinColumns({@JoinColumn(name = "team_alias", referencedColumnName = "alias"), @JoinColumn(name = "roomId", referencedColumnName = "roomId")})
    private Team team;

    public boolean hasTeam() {
        return (this.team != null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(id, user.id) &&
                Objects.equal(name, user.name) &&
                Objects.equal(email, user.email);
    }
}

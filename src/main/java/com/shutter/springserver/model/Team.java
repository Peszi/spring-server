package com.shutter.springserver.model;

import com.shutter.springserver.key.TeamPK;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@IdClass(TeamPK.class)
@Table(name = "teams")
public class Team {

    @Id
    private Integer id;

    @ManyToOne
    @Id
    @JoinColumn(name="roomId")
    private Room roomId;

    @OneToMany(mappedBy = "team", cascade = CascadeType.MERGE)
    private Set<User> users = new HashSet<>();

    @Column(length = 32)
    private String alias;

    public boolean hasRoom() {
//        return (this.roomId != null) ? true : false;
        return false;
    }

    public void addUser(User user) {
        this.users.add(user);
        user.setTeam(this);;
    }

    public void removeUser(User user) {
        user.setTeam(null);
        this.users.remove(user);
    }

}

package com.shutter.springserver.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name="host_id")
    private User host;

    private Boolean isStarted;

//    @Column(nullable = false, updatable = false)
//    @CreationTimestamp
//    private Date createdAt;

    @OneToMany(mappedBy = "roomId", cascade = CascadeType.MERGE)
    private List<Team> teams = new ArrayList<>();

    public void addUser(User user, int teamId) {
        this.teams.get(teamId).addUser(user);
    }

    public void removeUser(User user, int teamId) {
        this.teams.get(teamId).removeUser(user);
    }

    public int getUsersCount() {
        return this.teams.size();
    }

    public long getHostId() {
        return this.host.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id != null ? id.equals(room.id) : room.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}

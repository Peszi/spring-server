package com.shutter.springserver.model;

import com.shutter.springserver.data.GameType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

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

    @Enumerated(EnumType.ORDINAL)
    private GameType gameType;

//    @Column(nullable = false, updatable = false)
//    @CreationTimestamp
//    private Date createdAt;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    private List<Team> teams = new ArrayList<>();

    public void addTeam(Team team) {
        this.teams.add(team);
        team.setRoom(this);
    }

    public void removeTeam(Team team) {
        team.setRoom(null);
        this.teams.remove(team);
    }

    public int getTeamsCount() {
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

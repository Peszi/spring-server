package com.shutter.springserver.model;

import com.shutter.springserver.key.GameType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "host_id")
    private User host;

    private Boolean started;

    @Enumerated(EnumType.ORDINAL)
    private GameType mode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zc_mode_id", referencedColumnName = "id")
    private ModeZoneControl zcMode;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public Zone getMainZone() {
        if (this.zone == null)
            this.zone = new Zone();
        return this.zone;
    }

    public int getGameMode() {
        return this.mode.ordinal();
    }

    public String getCreatedDate() {
        if (this.created != null)
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(this.created);
        return "no date";
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

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
    private Long id;

    @OneToOne
    @JoinColumn(name = "host_id")
    private User host;

    @Column(name = "game_started")
    private Boolean isStarted;

    @Enumerated(EnumType.ORDINAL)
    private GameType gameType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zone_id")
    private Zone mainZone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zone_control_id", referencedColumnName = "id")
    private ModeZoneControl zoneControl;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

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

    public Zone getBaseZone() {
        if (this.mainZone == null)
            this.mainZone = new Zone();
        return this.mainZone;
    }

    public int getGameMode() {
        return this.gameType.ordinal();
    }

    public String getCreatedDate() {
        if (this.createdAt != null)
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(this.createdAt);
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

package com.shutter.springserver.model;

import com.shutter.springserver.key.TeamPK;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
//@IdClass(TeamPK.class)
@Table(name = "teams", uniqueConstraints={
        @UniqueConstraint(columnNames = {"room_id", "alias"})
})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @Id
    @JoinColumn(name="room_id")
    private Room room;

//    @Id
    @Column(length = 32)
    private String alias;

    @OneToMany(mappedBy = "team", cascade = CascadeType.MERGE)
    private Set<User> users = new HashSet<>();

    public boolean hasRoom() {
        return (this.room != null) ? true : false;
    }

    public void addUser(User user) {
        this.users.add(user);
        user.setTeam(this);
    }

    public void removeUser(User user) {
        user.setTeam(null);
        this.users.remove(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id != null ? id.equals(team.id) : team.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

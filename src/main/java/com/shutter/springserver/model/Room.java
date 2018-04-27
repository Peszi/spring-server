package com.shutter.springserver.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "room", cascade = CascadeType.MERGE)
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        this.users.add(user);
        user.setRoom(this);;
    }

    public void removeUser(User user) {
        user.setRoom(null);
        this.users.remove(user);
    }

    public int getUsersCount() {
        return this.users.size();
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

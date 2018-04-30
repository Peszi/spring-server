package com.shutter.springserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Room.class)
    @JoinColumn(name="room_id")
    private Room room;

    private String alias;

}

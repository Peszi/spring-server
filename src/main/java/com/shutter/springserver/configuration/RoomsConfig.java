package com.shutter.springserver.configuration;

import com.shutter.springserver.model.Room;
import com.shutter.springserver.repository.RoomRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RoomsConfig {

    private RoomRepository roomRepository;

    public RoomsConfig(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void init() {
        for (Room room : this.roomRepository.findAll())
            if (room.getStarted()) {
                room.setStarted(false);
                this.roomRepository.save(room);
            }
    }
}

package com.shutter.springserver.repository;

import com.shutter.springserver.model.Room;
import com.shutter.springserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findRoomByHost(User host);
    Optional<Room> findRoomByHostId(Integer host_id);
}

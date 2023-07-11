package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.model.Room;

import java.util.List;

public interface RoomRepository {
    Room saveRoom(Room room);

    Room findRoomById(Long id);

    void deleteRoomById(Long id);

    List<Room> fndAllRooms();
}

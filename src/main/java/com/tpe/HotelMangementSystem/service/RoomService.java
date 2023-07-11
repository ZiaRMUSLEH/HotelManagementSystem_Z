package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.model.Room;

import java.util.List;

public interface RoomService {

    Room saveRoom();
    Room findRoomById(Long id);
    List<Room> findAllRooms();
    void deleteRoomById(Long id);

}

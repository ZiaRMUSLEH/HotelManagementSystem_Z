package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.model.Hotel;

import java.util.List;

public interface HotelRepository {

    Hotel saveHotel(Hotel hotel);

    Hotel findHotelById(Long id);

    List<Hotel> findAllHotels();

    void deleteHotelById(Long id);


    void updateHotel(Hotel existingHotel);





}

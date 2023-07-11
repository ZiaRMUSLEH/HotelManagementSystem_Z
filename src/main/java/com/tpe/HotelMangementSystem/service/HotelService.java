package com.tpe.HotelMangementSystem.service;
import com.tpe.HotelMangementSystem.exception.HotelResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Hotel;

import java.util.List;

public interface HotelService {
    //step 13c: saveHotel
    Hotel saveHotel();

    Hotel findHotelById(Long id);

    List<Hotel> findAllHotels();

    void deleteHotelById(Long id);

    void updateHotelByID(Long id, Hotel updateHotel) throws HotelResourceNotFoundException;







}
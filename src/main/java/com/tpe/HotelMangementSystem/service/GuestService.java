package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.model.Guest;
import com.tpe.HotelMangementSystem.model.Hotel;

import java.util.List;

public interface GuestService {

    Guest saveGuest();

    void findGuestById (Long id);

    void deleteGuestById(Long id);

    List<Guest> findAllGuests();


}

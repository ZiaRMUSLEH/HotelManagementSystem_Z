package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.model.Guest;

import java.util.List;

public interface GuestRepository {

    void saveGuest(Guest guest);

    Guest findGuestById(Long id);

    void deleteGuestById(Long id);

    List<Guest> findAllGuest();

    

}

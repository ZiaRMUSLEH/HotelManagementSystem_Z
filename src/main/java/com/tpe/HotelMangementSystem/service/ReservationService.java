package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.model.Reservation;
import com.tpe.HotelMangementSystem.model.Room;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation();
    Reservation findReservationById(Long id);
    List<Reservation> findAllReservation();
    void deleteReservationById(Long id);
}

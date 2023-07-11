package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.model.Reservation;
import com.tpe.HotelMangementSystem.model.Room;

import java.util.List;

public interface ReservationRepository {

    Reservation saveReservation(Reservation reservation);

    Reservation findReservationById(Long id);

    void deleteReservationById(Long id);

    List<Reservation> fndAllReservations();
}

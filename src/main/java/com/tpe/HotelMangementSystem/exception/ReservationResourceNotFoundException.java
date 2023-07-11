package com.tpe.HotelMangementSystem.exception;

public class ReservationResourceNotFoundException extends RuntimeException {
    public ReservationResourceNotFoundException (String message){
        super(message);
    }
}

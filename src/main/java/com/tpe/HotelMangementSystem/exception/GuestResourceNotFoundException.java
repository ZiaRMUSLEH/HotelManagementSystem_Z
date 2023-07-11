package com.tpe.HotelMangementSystem.exception;

public class GuestResourceNotFoundException extends RuntimeException{
    public GuestResourceNotFoundException(String message){
        super(message);
    }
}

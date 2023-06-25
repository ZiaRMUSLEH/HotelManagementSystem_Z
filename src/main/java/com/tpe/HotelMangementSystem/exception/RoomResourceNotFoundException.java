package com.tpe.HotelMangementSystem.exception;

//step 8: create custom exception
public class RoomResourceNotFoundException extends RuntimeException{
    public RoomResourceNotFoundException(String message){
        super(message);
    }
}
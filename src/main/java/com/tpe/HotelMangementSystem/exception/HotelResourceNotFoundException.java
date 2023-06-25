package com.tpe.HotelMangementSystem.exception;
public class HotelResourceNotFoundException extends RuntimeException{
    public HotelResourceNotFoundException(String message){
        super(message);
    }
}
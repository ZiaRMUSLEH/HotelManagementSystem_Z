package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.exception.HotelResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Hotel;
import com.tpe.HotelMangementSystem.repository.HotelRepository;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class HotelServiceImpl implements HotelService{


    private  static Scanner scanner;

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;

    }
    // HotelRepository hotelRepository= new HotelRepositoryImpl();

    //stp13d: saveHotel
    @Override
    public Hotel saveHotel() {


        scanner= new Scanner(System.in);
        Hotel hotel= new Hotel();

        System.out.println("Enter hotel Id :");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();//consume the new Line
        System.out.println("Enter The Hotel Name :");
        hotel.setName(scanner.nextLine());
        System.out.println("Enter the Hotel Location : ");
        hotel.setLocation(scanner.nextLine());

        //save the hotel object using hotelRepository
        hotelRepository.saveHotel(hotel);

        System.out.println("Hotel saved  successfully! :  "+hotel.getId());
        return hotel;

    }

    @Override
    public Hotel findHotelById (Long id) {
        try{
            Hotel foundHotels = hotelRepository.findHotelById(id);
            if(foundHotels!=null){
                System.out.println("-----------------------------");
                System.out.println(foundHotels);
                return foundHotels;
            }else {
                throw new HotelResourceNotFoundException("Hotel not found by ID: " +id);
            }
        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Hotel> findAllHotels() {
        try {
            List<Hotel> hotels =  hotelRepository.findAllHotels();

            if (!hotels.isEmpty()){
                System.out.println("List of Hotels: ");

                for (Hotel hotel:hotels){
                    System.out.println(hotel);
                    System.out.println("------------------------------");
                }
            }else {
                System.out.println("Hotel List is Empty ..");
            }
            return hotels;
        }catch (Exception e){
            System.out.println("An error occurred while retrieving hotel : "+e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteHotelById (Long id) {
        scanner= new Scanner(System.in);
        try{
          Hotel hotelDeleted =   hotelRepository.findHotelById(id);
          if(hotelDeleted==null){
              throw new HotelResourceNotFoundException("hotel not found by id: "+id);

          }
            System.out.println(hotelDeleted);

            System.out.println("Are you sure you want to delete the Hotel with id: "+hotelDeleted.getId());
            String confirmation = scanner.nextLine();
            if(confirmation.equalsIgnoreCase("y")){
                hotelRepository.deleteHotelById(hotelDeleted.getId());
                System.out.println("hotel deleted successfully id: " +hotelDeleted.getId());
            } else {
                System.out.println("delete operation canceled");
            }
        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateHotelByID(Long id, Hotel updateHotel) throws HotelResourceNotFoundException {

        try {
            Hotel existingHotel = hotelRepository.findHotelById(id);
            if (existingHotel==null){
                throw new HotelResourceNotFoundException("Hotel not found With Id : "+id);
            }

            existingHotel.setName(updateHotel.getName());
            existingHotel.setName(updateHotel.getName());

            hotelRepository.updateHotel(existingHotel);

            System.out.println("Hotel updated Successfully ...");

        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());

        }

    }
}
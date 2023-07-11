package com.tpe.HotelMangementSystem.service;
import com.tpe.HotelMangementSystem.exception.GuestResourceNotFoundException;
import com.tpe.HotelMangementSystem.exception.HotelResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Address;
import com.tpe.HotelMangementSystem.model.Guest;
import com.tpe.HotelMangementSystem.model.Hotel;
import com.tpe.HotelMangementSystem.repository.GuestRepository;

import java.util.List;
import java.util.Scanner;
public class GuestServiceImpl implements GuestService{
    //step 22D :save guest
    private Scanner scanner;
    private final GuestRepository guestRepository;
    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
    @Override
    public Guest saveGuest() {
        scanner= new Scanner(System.in);
        //create guest object
        Guest guest= new Guest();
        System.out.println("Enter Guest Name:");
        guest.setName(scanner.nextLine());
        //create address Object
        Address address= new Address();
        System.out.println("Enter Guest Street : ");
        address.setStreet(scanner.nextLine());
        System.out.println("Enter Guest City : ");
        address.setCity(scanner.nextLine());
        System.out.println("Enter Guest Country : ");
        address.setCountry(scanner.nextLine());
        System.out.println("Enter Guest zipCode : ");
        address.setZipCode(scanner.nextInt());
        //set address for the Guest
        guest.setAddress(address);
        guestRepository.saveGuest(guest);
        System.out.println("Guest  Save Successfully  ! Guest Id:  "+guest.getId());
        return guest;
    }

    @Override
    public void findGuestById (Long id) {
        try{
            Guest foundGuest = guestRepository.findGuestById(id);
            if(foundGuest!=null){
                System.out.println("-----------------------------");
                System.out.println(foundGuest);
            }else {
                throw new GuestResourceNotFoundException("Guest not found by ID: "+id);
            }
        }catch (GuestResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteGuestById (Long id) {
        scanner= new Scanner(System.in);
        try{
            Guest guestDeleted =   guestRepository.findGuestById(id);
            if(guestDeleted==null){
                throw new GuestResourceNotFoundException("guest not found by id: "+id);

            }
            System.out.println(guestDeleted);

            System.out.println("Are you sure you want to delete the Guest with id: "+guestDeleted.getId());
            String confirmation = scanner.nextLine();
            if(confirmation.equalsIgnoreCase("y")){
                guestRepository.deleteGuestById(guestDeleted.getId());
                System.out.println("guest deleted successfully id: " +guestDeleted.getId());
            } else {
                System.out.println("delete operation canceled");
            }
        }catch (GuestResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Guest> findAllGuests () {
        try {
            List<Guest> guests =  guestRepository.findAllGuest();

            if (!guests.isEmpty()){
                System.out.println("List of Guests: ");

                for (Guest guest:guests){
                    System.out.println(guest);
                    System.out.println("------------------------------");
                }
            }else {
                System.out.println("Guest List is Empty ..");
            }
            return guests;
        }catch (Exception e){
            System.out.println("An error occurred while retrieving guest : "+e.getMessage());
            return null;
        }
    }
}
package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.exception.GuestResourceNotFoundException;
import com.tpe.HotelMangementSystem.exception.ReservationResourceNotFoundException;
import com.tpe.HotelMangementSystem.exception.RoomResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Guest;
import com.tpe.HotelMangementSystem.model.Reservation;
import com.tpe.HotelMangementSystem.model.Room;
import com.tpe.HotelMangementSystem.repository.GuestRepository;
import com.tpe.HotelMangementSystem.repository.ReservationRepository;
import com.tpe.HotelMangementSystem.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationServiceImpl implements ReservationService{

    private Scanner scanner;
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public ReservationServiceImpl (ReservationRepository reservationRepository, GuestRepository guestRepository, RoomRepository roomRepository) {
        this.scanner = scanner;
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }


    @Override
    public Reservation saveReservation() {
        scanner=new Scanner(System.in);
        System.out.println("Enter guest Id :");
        Long guestId=scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter the Room Id :");
        Long roomId=scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter the checkinDate (yyyy-MM-dd)");//2023-12-12
        LocalDate checkInDate=LocalDate.parse(scanner.nextLine());
        System.out.println("Enter the checkoutDate (yyyy-MM-dd)");//2023-12-12
        LocalDate checkoutDate=LocalDate.parse(scanner.nextLine());
        try {
            Room existRoom = roomRepository.findRoomById(roomId);
            if (existRoom==null){
                throw new RoomResourceNotFoundException("Room not found with Id : "+roomId);
            }
            Guest existGuest=  guestRepository.findGuestById(guestId);
            if (existGuest==null){
                throw new GuestResourceNotFoundException("Guest not found with Id : "+guestId);
            }
            Reservation reservation = new Reservation();
            reservation.setGuest(existGuest);
            reservation.setRoom(existRoom);
            reservation.setCheckinDate(checkInDate);
            reservation.setCheckoutDate(checkoutDate);
            reservationRepository.saveReservation(reservation);
            System.out.println("Reservation saved successfully .! Reservation Id :" +reservation.getId());
            return reservation;
        }catch (GuestResourceNotFoundException | RoomResourceNotFoundException gr){
            System.out.println(gr.getMessage());
        }
        return null;
    }

    @Override
    public Reservation findReservationById (Long id) {
        try{
            Reservation foundReservation = reservationRepository.findReservationById(id);
            if(foundReservation!=null){
                System.out.println("--------------------------------");
                System.out.println(foundReservation);
                return foundReservation;
            }else {
                throw new ReservationResourceNotFoundException("Reservation not found by id: "+id);
            }
        }catch (ReservationResourceNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reservation> findAllReservation () {
        try{
            List<Reservation> reservations = reservationRepository.fndAllReservations();
            if(!reservations.isEmpty()){
                System.out.println("List of Reservations: ");
                reservations.forEach(System.out::println);
                System.out.println("-------------------------");
            }else {
                System.out.println("Reservation List is Empty...");
            }
            return reservations;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteReservationById (Long id)  {
        scanner = new Scanner(System.in);
        try{
            Reservation reservationDeleted = reservationRepository.findReservationById(id);
            if(reservationDeleted==null){
                throw new ReservationResourceNotFoundException("reservation not found by id: "+id);
            }
            System.out.println(reservationDeleted);
            System.out.println("Are you sure you wan to delete the reservation with id: "+reservationDeleted.getId());
            String confirmation = scanner.nextLine();
            if(confirmation.equalsIgnoreCase("y")){
                reservationRepository.deleteReservationById(reservationDeleted.getId());
                System.out.println("reservation deleted successfully id: "+reservationDeleted.getId());
            }else {
                System.out.println("delete operation cancelled");
            }
        }catch (ReservationResourceNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}

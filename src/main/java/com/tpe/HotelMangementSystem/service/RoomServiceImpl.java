package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.exception.HotelResourceNotFoundException;
import com.tpe.HotelMangementSystem.exception.RoomResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Hotel;
import com.tpe.HotelMangementSystem.model.Room;
import com.tpe.HotelMangementSystem.repository.HotelRepository;
import com.tpe.HotelMangementSystem.repository.RoomRepository;

import java.util.List;
import java.util.Scanner;

public class RoomServiceImpl implements RoomService{

    private static Scanner scanner;

    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;

    public RoomServiceImpl (RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }


    @Override
    public Room saveRoom () {
        scanner = new Scanner(System.in);
        Room room = new Room();
        System.out.print("Enter room Id: ");
        room.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Enter room Number: ");
        room.setNumber(scanner.nextLine());
        System.out.print("Enter room Capacity: ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter hotel id: ");
        Long hotelId = scanner.nextLong();
        try {
            Hotel existingHotel = hotelRepository.findHotelById(hotelId);
            if (existingHotel == null) {
                throw new HotelResourceNotFoundException("Hotel not found with id: " + hotelId);
            }
            room.setHotel(existingHotel);
            Room saveRoom = roomRepository.saveRoom(room);

            existingHotel.getRooms().add(saveRoom);
            System.out.println("Room saved successfully! Room id: " + saveRoom.getId());
        } catch (HotelResourceNotFoundException e) {
            System.out.println(e.getMessage());

        }
        return room;
    }

    @Override
    public Room findRoomById (Long id) {
        try{
            Room foundRooms = roomRepository.findRoomById(id);
            if(foundRooms!=null){
                System.out.println("---------------------------");
                System.out.println(foundRooms);
                return foundRooms;
            }else {
                throw new RoomResourceNotFoundException("Room not found by ID: "+id);
            }
        }catch (RoomResourceNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Room> findAllRooms () {
        try{
            List<Room> rooms = roomRepository.fndAllRooms();
            if(!rooms.isEmpty()){
                System.out.println("List of Rooms: ");
                for(Room room: rooms){
                    System.out.println(room);
                    System.out.println("-----------------------------");
                }
            }else {
                System.out.println("Room List is Empty...");
            }
            return rooms;
        }catch (Exception e){
            System.out.println("An error occurred while retrieving room: "+e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteRoomById (Long id) {
        scanner = new Scanner(System.in);
        try{
           Room roomDeleted = roomRepository.findRoomById(id);
           if(roomDeleted==null){
               throw new RoomResourceNotFoundException("room not found by id: "+id);
           }
            System.out.println(roomDeleted);
            System.out.println("Are you sure you wan to delete the room with id: "+roomDeleted.getId());
            String confirmation = scanner.nextLine();
            if(confirmation.equalsIgnoreCase("y")){
                roomRepository.deleteRoomById(roomDeleted.getId());
                System.out.println("room deleted successfully id: "+roomDeleted.getId());
            }else {
                System.out.println("delete operation cancelled");
            }
        }catch (RoomResourceNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}

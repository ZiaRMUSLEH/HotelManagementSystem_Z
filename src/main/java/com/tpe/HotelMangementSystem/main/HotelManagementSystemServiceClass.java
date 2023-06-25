package com.tpe.HotelMangementSystem.main;
import java.util.Scanner;
public class HotelManagementSystemServiceClass {

    private static Scanner scanner;
    //step 10
    public static  void displayMenuHotelManagementSystem(){
        //create  a scanner for user input
        scanner= new Scanner(System.in);
        //menu
        boolean exit = false;
        while (!exit){
            System.out.println("==== Hotel Management System  Menu ====");
            System.out.println("1. Hotel Operations");
            System.out.println("2. Room Operations");
            System.out.println("3. Guest Operations");
            System.out.println("4. Reservation Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    displayHotelOperationMenu();
                    break;
                case 2:
                    displayRoomOperationMenu();
                    break;
                case 3:
                    displayGuestOperationMenu();
                    break;
                case 4:
                    displayReservationOperationMenu();
                    break;
                case 5:
                    exit=true;
                    System.out.println("Good Bye !!!!!");
                    break;
                default:
                    System.out.println("Invalid choice .Please try again ..");
                    break;
            }
        }
    }
    //step13:
    private static void displayHotelOperationMenu(){
        scanner= new Scanner(System.in);

            System.out.println("Option 1: Hotel Operations");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find a hotel by ID");
            System.out.println("3. Update a hotel");
            System.out.println("4. Delete a hotel");
            System.out.println("5. View all hotels");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("1. Add a new hotel");
                    break;
                case 2:
                    System.out.println("2. Find a hotel by ID");
                    break;
                case 3:
                    System.out.println("3. Update a hotel");
                    break;
                case 4:
                    System.out.println("4. Delete a hotel");
                    break;
                case 5:
                    System.out.println("5. View all hotels");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice .Please try again ..");
                    break;
            }
        }

    //step 18:
    private static void displayRoomOperationMenu(){
        scanner= new Scanner(System.in);

        System.out.println("Option 2: Room Operations");
        System.out.println("1. Add a new room");
        System.out.println("2. Find a room by ID");
        System.out.println("3. Update a room");
        System.out.println("4. Delete a room");
        System.out.println("5. View all rooms");
        System.out.println("6. Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("1. Add a new room");
                break;
            case 2:
                System.out.println("2. Find a room by ID");
                break;
            case 3:
                System.out.println("3. Update a room");
                break;
            case 4:
                System.out.println("4. Delete a room");
                break;
            case 5:
                System.out.println("5. View all rooms");
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid choice .Please try again ..");
                break;
        }
    }
    //step 22
    private static void displayGuestOperationMenu(){
        scanner= new Scanner(System.in);

        System.out.println("Option 3: Guest Operations");
        System.out.println("1. Add a new guest");
        System.out.println("2. Find a guest by ID");
        System.out.println("3. Update a guest");
        System.out.println("4. Delete a guest");
        System.out.println("5. View all guests");
        System.out.println("6. Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("1. Add a new guest");
                break;
            case 2:
                System.out.println("2. Find a guest by ID");
                break;
            case 3:
                System.out.println("3. Update a guest");
                break;
            case 4:
                System.out.println("4. Delete a guest");
                break;
            case 5:
                System.out.println("5. View all guest");
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid choice .Please try again ..");
                break;
        }
    }
    private static void displayReservationOperationMenu(){
        scanner= new Scanner(System.in);

        System.out.println("Option 4: Reservation Operations");
        System.out.println("1. Add a new room");
        System.out.println("2. Find a reservation by ID");
        System.out.println("3. Update a reservation");
        System.out.println("4. Delete a reservation");
        System.out.println("5. View all reservations");
        System.out.println("6. Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("1. Add a new reservation");
                break;
            case 2:
                System.out.println("2. Find a reservation by ID");
                break;
            case 3:
                System.out.println("3. Update a reservation");
                break;
            case 4:
                System.out.println("4. Delete a reservation");
                break;
            case 5:
                System.out.println("5. View all reservation");
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid choice .Please try again ..");
                break;
        }
    }
}


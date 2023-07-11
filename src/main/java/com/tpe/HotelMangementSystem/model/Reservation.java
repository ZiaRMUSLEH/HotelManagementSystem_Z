package com.tpe.HotelMangementSystem.model;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "tbl_reservation")
public class Reservation {
    //step 9d: create reservation Entity
    //step 26 :fill the filed of Reservation
    @GeneratedValue(generator = "sequence" ,strategy = GenerationType.SEQUENCE)//1001-1002-1003
    @SequenceGenerator(name = "sequence",
            sequenceName = "reservation_id",
            initialValue = 1000,
            allocationSize = 1)
    @Id
    private Long id;
    @Column(nullable = false)
    private LocalDate checkinDate;
    @Column(nullable = false)
    private LocalDate checkoutDate;
    @ManyToOne
    @JoinColumn(name = "guest_id",nullable = false)
    private Guest guest;
    @ManyToOne
    @JoinColumn(name = "room_id",nullable = false)
    private Room room;
    public Long getId() {
        return id;
    }
    public LocalDate getCheckinDate() {
        return checkinDate;
    }
    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }
    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    public Guest getGuest() {
        return guest;
    }
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    //to String method
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
//                ", guest=" + guest +
                ", room=" + room +
                '}';
    }
}
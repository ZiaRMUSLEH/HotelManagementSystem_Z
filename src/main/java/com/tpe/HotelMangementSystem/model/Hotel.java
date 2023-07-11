package com.tpe.HotelMangementSystem.model;
//step 9a: Hotel Entity

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_hotels")
public class Hotel {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;


    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();

    @Override
    public String toString () {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                '}';
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getLocation () {
        return location;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public List<Room> getRooms () {
        return rooms;
    }

    public void setRooms (List<Room> rooms) {
        this.rooms = rooms;
    }

    public Hotel () {
    }

    public Hotel (Long id, String name, String location, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rooms = rooms;
    }
}

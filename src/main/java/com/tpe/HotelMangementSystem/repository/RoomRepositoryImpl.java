package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.exception.RoomResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepositoryImpl implements RoomRepository{


    @Override
    public Room saveRoom(Room room) {

        try (Session session = HibernateUtils.getSessionFactory().openSession()){

            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
            session.close();

            return room;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Room findRoomById (Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Room.class,id);
    }

    @Override
    public void deleteRoomById (Long id) {
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Room deleteRoom = session.get(Room.class, id);
            if(deleteRoom!=null){
                session.delete(deleteRoom);
                transaction.commit();
                HibernateUtils.closeSession(session);
            }else {
                throw  new RoomResourceNotFoundException("Room not found with id: "+id);
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Room> fndAllRooms () {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.createQuery("FROM Room",Room.class).getResultList();
    }
}

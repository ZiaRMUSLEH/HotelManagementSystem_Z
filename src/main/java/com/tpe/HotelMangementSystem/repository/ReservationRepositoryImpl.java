package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.exception.ReservationResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository{
    @Override
    public Reservation saveReservation(Reservation reservation) {
        try(Session session= HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(reservation);
            transaction.commit();
            return reservation;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Reservation findReservationById (Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Reservation.class,id);
    }

    @Override
    public void deleteReservationById (Long id) {
    try{Session session= HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Reservation foundReservation = session.get(Reservation.class,id);
        if(foundReservation!=null){
            session.delete(foundReservation);
            transaction.commit();
            HibernateUtils.closeSession(session);
        }else {
            throw new ReservationResourceNotFoundException("Reservation not found by id: "+id);
        }

}catch (HibernateException e){
        e.printStackTrace();
}

    }

    @Override
    public List<Reservation> fndAllReservations () {
       Session session = HibernateUtils.getSessionFactory().openSession();
        return session.createQuery("FROM Reservation",Reservation.class).getResultList();
    }
}

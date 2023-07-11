package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.exception.GuestResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Address;
import com.tpe.HotelMangementSystem.model.Guest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GuestRepositoryImpl implements GuestRepository{



    //step 22 b : save Guest
    @Override
    public void saveGuest(Guest guest) {

        try (Session session= HibernateUtils.getSessionFactory().openSession()){

            Transaction transaction= session.beginTransaction();

            //create  a new Address object and set properties

            Address address= new Address();
            address.setStreet(guest.getAddress().getStreet());
            address.setCity(guest.getAddress().getCity());
            address.setCountry(guest.getAddress().getCountry());
            address.setZipCode(guest.getAddress().getZipCode());

            //set address to Guest
            guest.setAddress(address);

            session.save(guest);

            transaction.commit();
            HibernateUtils.closeSession(session);
//            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Guest findGuestById(Long guestId) {
        Session session=HibernateUtils.getSessionFactory().openSession();
        return session.get(Guest.class,guestId);}


        @Override
    public void deleteGuestById (Long id) {
       try{ Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Guest deleteGuest = session.get(Guest.class,id);
        if(deleteGuest!=null){
            session.delete(deleteGuest);
            transaction.commit();
            HibernateUtils.closeSession(session);
        }else {throw  new GuestResourceNotFoundException("Guest not found with id: "+id);
        }

    }catch (HibernateException e){
           e.printStackTrace();
       }
    }

    @Override
    public List<Guest> findAllGuest () {
        Session session =HibernateUtils.getSessionFactory().openSession();
        return session.createQuery("FROM Guest",Guest.class).getResultList();
    }
}
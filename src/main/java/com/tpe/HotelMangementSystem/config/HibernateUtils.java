package com.tpe.HotelMangementSystem.config;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//step 7: HibernateUtils
public class HibernateUtils {
    private static  SessionFactory sessionFactory;
    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation is failed ...."+ex);
            throw  new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void shutDown(){
        getSessionFactory().close();
    }
    public static void closeSession(Session session){
        if (session!=null && session.isOpen()){
            session.close();
        }
    }
}
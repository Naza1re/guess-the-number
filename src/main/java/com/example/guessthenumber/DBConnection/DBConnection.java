package com.example.guessthenumber.DBConnection;

import com.example.guessthenumber.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DBConnection {

    public static Session getSession(){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
    public static User getUserById(int id){
        Session session = DBConnection.getSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.close();
        return user;

    }
    public static User getLastAddedUser() {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM User ORDER BY id DESC");
        query.setMaxResults(1);

        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        return user;
    }


}

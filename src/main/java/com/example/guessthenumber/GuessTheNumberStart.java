package com.example.guessthenumber;

import com.example.guessthenumber.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuessTheNumberStart {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        try {

        }
        finally {
            factory.close();

        }


    }
}

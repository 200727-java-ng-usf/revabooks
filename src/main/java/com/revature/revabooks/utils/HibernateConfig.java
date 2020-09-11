package com.revature.revabooks.utils;

import com.revature.revabooks.models.AppUser;
import jdk.nashorn.internal.runtime.ECMAException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private HibernateConfig() {
        super();
    }

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {

        try {

            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            cfg.addAnnotatedClass(AppUser.class);
            return cfg.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionFactory() {
        return (sessionFactory == null) ? sessionFactory = buildSessionFactory() : sessionFactory;
    }

}
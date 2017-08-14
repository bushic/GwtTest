package gwtTest.server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {


    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory( ) {

        SessionFactory session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        sessionFactory = session;
        return session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

package ormrelationships.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
    public static void main(String[] args){

        Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Driver.class)
                .configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Car c1 = new Car();
        c1.setBrand("Celerio");
        c1.setCid(1);
        c1.setMileage(100);


        Driver d1 = new Driver();
        d1.setDid(1);
        d1.setAge(30);
        d1.setExperience(5);

        d1.setCar(c1);
        c1.setDriver(d1);

        Transaction t1 = session.beginTransaction();

        session.persist(d1);
        session.persist(c1);

        t1.commit();
        session.close();
        sessionFactory.close();
    }
}

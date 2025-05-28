package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDdlExample {
    public static void main(String[] args){
        Alien alien = new Alien();
        alien.setAid(6);
        alien.setAname("Bhanu");
        alien.setTech("JAVA");
        Laptop laptop = new Laptop();
        laptop.setBrand("Apple");
        laptop.setModel("Macbook Pro");
        laptop.setRam(16);
        alien.setLaptop(laptop);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(hibernate.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();


        //create
        Transaction transaction = session.beginTransaction();
        session.persist(alien);
        transaction.commit();


        session.close();
        sessionFactory.close();
    }
}

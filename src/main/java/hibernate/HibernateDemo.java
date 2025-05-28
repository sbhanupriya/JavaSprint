package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
    public static void main(String[] args){
        Employee employee = new Employee();
        employee.setAge(29);
        employee.setName("Harsh");
        employee.setEmpId(7);


        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(hibernate.Employee.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();


        //create
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();


        //get
        Employee emp = session.get(Employee.class, 1);
        System.out.println(emp);

        //update
        transaction = session.beginTransaction();
        employee.setAge(31);
        session.merge(employee);
        transaction.commit();

        //delete
        transaction = session.beginTransaction();
        session.remove(emp);
        transaction.commit();


        session.close();
        sessionFactory.close();
    }
}

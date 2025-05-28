package ormrelationships.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManyToManyDemo {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Teacher.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Course c1 = new Course();
        c1.setCid(1);
        c1.setName("JAVA - programming");
        c1.setOptional(true);

        Course c2 = new Course();
        c2.setCid(2);
        c2.setName("Maths");
        c2.setOptional(false);

        Teacher teacher = new Teacher();
        teacher.setName("Bhanu Priya");
        teacher.setId(1);
        teacher.setCourses(List.of(c1,c2));


        Teacher teacher1 = new Teacher();
        teacher1.setId(2);
        teacher1.setName("Shivam");
        teacher1.setCourses(List.of(c1));

        Transaction transaction = session.beginTransaction();

        c1.setTeachers(List.of(teacher,teacher1));
        c2.setTeachers(List.of(teacher));

        session.persist(c1);
        session.persist(c2);
        session.persist(teacher1);
        session.persist(teacher);
        transaction.commit();

        System.out.println(session.get(Teacher.class, 1));

        session.close();
        sessionFactory.close();

    }
}

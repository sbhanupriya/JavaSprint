package ormrelationships.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OneToManyDemo {
    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Blog.class)
                .addAnnotatedClass(Post.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Post p1 = new Post();
        p1.setAuthor("Bhanu");
        p1.setPid(1);
        p1.setHeading("System Design");

        Post p2 = new Post();
        p2.setAuthor("Aditya");
        p2.setPid(2);
        p2.setHeading("System Design - LLD");

        Blog blog = new Blog();
        blog.setOwner("Bhanu");
        blog.setName("SDE1 to SDE2");
        blog.setBid(1);
        blog.setPostList(List.of(p1,p2));

        p1.setBlog(blog);
        p2.setBlog(blog);

        Transaction transaction = session.beginTransaction();
        session.persist(p1);
        session.persist(p2);
        session.persist(blog);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

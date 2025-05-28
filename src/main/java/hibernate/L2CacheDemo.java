package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ormrelationships.onetomany.Blog;
import ormrelationships.onetomany.Post;

public class L2CacheDemo {
    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Blog.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Post post = session.get(Post.class, 1);
        System.out.println(post);
        post = session.get(Post.class, 1);

        Session session2 = sessionFactory.openSession();

        post = session2.get(Post.class, 1);
        System.out.println(post);

        session.close();
        session2.close();
        sessionFactory.close();

    }
}

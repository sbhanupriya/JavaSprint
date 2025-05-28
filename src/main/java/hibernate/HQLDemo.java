package hibernate;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ormrelationships.onetomany.Blog;
import ormrelationships.onetomany.Post;

import java.util.List;

public class HQLDemo {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Blog.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Post");
        List<Post> postList = query.getResultList();
        System.out.println(postList);
        System.out.println("My Posts " + session.createQuery("from Post where author = 'Bhanu'").getResultList());

        System.out.println("System Design Posts " + session.createQuery("from Post where heading like 'Tech %'").getResultList());

        String heading = "System Design";
        query = session.createQuery("select author from Post where heading like ?1");
        query.setParameter(1,heading);
        List<String> posts = query.getResultList();
        System.out.println("System Design Posts " + posts);


        Session s1 = sessionFactory.openSession();
        //Lazy loading
        s1.load(Post.class,1);
        //Eager loaidng
        s1.get(Post.class, 3);

        session.close();
        sessionFactory.close();
    }
}

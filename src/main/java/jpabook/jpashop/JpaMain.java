package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Book book = new Book();
            book.setIsbn("JPA2");
            book.setAuthor("kim2");

            em.persist(book);

            Movie movie = new Movie();
            movie.setDirector("didid");
            movie.setActor("aa");
            movie.setName("sdfsdf");
            movie.setPrice(100);
            em.persist(movie);

            em.flush();
            em.close();

            List<Item> s = em.createQuery("select m from Item m", Item.class)
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}

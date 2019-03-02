package net.zonia3000.jpademo.executor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import net.zonia3000.jpademo.JPAExecutor;
import net.zonia3000.jpademo.Libro;

/**
 * Detached state
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Example3 extends JPAExecutor {

    private void beginTransaction(EntityManager em) {
        em.getTransaction().begin();
    }

    private void commit(EntityManager em) {
        em.getTransaction().commit();
    }

    @Override
    public void execute() {

        Libro libro = new Libro("Isaac Asimov", "Io, Robot");

        // Apertura EntityManager
        EntityManager em = createEntityManager();

        System.out.println("1: " + em.contains(libro));

        beginTransaction(em);
        em.persist(libro);
        commit(em);

        System.out.println("2: " + em.contains(libro));

        beginTransaction(em);
        libro.setTitolo("Abissi d'acciaio");
        commit(em);

        System.out.println("3: " + em.contains(libro));

        em.detach(libro);

        beginTransaction(em);
        libro.setTitolo("Trilogia della fondazione");
        commit(em);

        System.out.println("4: " + em.contains(libro));

        beginTransaction(em);
        em.merge(libro);
        commit(em);

        System.out.println("5: " + em.contains(libro));

        libro = em.merge(libro);
        System.out.println("6: " + em.contains(libro));
        
        em.detach(libro);

        System.out.println("7: " + em.contains(libro));

        libro = getLibroFromQuery(em);

        System.out.println("8: " + em.contains(libro));

        // Chiusura EntityManager
        em.close();

        System.out.println("9: " + em.contains(libro));
    }

    private Libro getLibroFromQuery(EntityManager em) {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.from(Libro.class);
        Query q = em.createQuery(cq);

        return (Libro) q.getResultList().get(0);
    }
}

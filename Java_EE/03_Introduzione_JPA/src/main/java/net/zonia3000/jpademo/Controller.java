package net.zonia3000.jpademo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Controller {

    private final EntityManagerFactory emf;

    public Controller() {
        emf = Persistence.createEntityManagerFactory("demo_pu");
    }

    public void aggiungiUtente(Utente utente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        em.close();
    }

    public void close() {
        emf.close();
    }

    public List<Utente> getUtenti() {
        EntityManager em = emf.createEntityManager();

//        List<Utente> ret = em.createNamedQuery("Utente.findAll", Utente.class).getResultList();
//
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Utente> root = cq.from(Utente.class);
        cq.select(root);
        Query q = em.createQuery(cq);

        List<Utente> ret = q.getResultList();

        em.close();
        return ret;
    }

    public Utente getUtenteByName(String username) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Utente.class);
        Root<Utente> root = cq.from(Utente.class);
        cq.where(cb.equal(root.get("username"), username));

        Query q = em.createQuery(cq);
        Utente ret = (Utente) q.getSingleResult();
        em.close();
        return ret;
    }

    public void aggiungiLibro(Utente utente, Libro libro) {
        EntityManager em = emf.createEntityManager();
        utente.getLibri().add(libro);
        em.getTransaction().begin();
        em.merge(utente);
        em.getTransaction().commit();
        em.close();
    }
}

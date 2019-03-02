package net.zonia3000.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public abstract class JPAExecutor {

    private final EntityManagerFactory emf;

    public JPAExecutor() {
        emf = Persistence.createEntityManagerFactory("demo_pu");
    }

    protected EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    private EntityManager startTransaction() {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    private void endTransaction(EntityManager em) {
        em.getTransaction().commit();
        em.close();
    }

    protected void persist(Object entity) {
        EntityManager em = startTransaction();
        em.persist(entity);
        endTransaction(em);
    }

    protected void merge(Object entity) {
        EntityManager em = startTransaction();
        em.merge(entity);
        endTransaction(em);
    }

    protected void remove(Object entity) {
        EntityManager em = startTransaction();
        em.remove(em.merge(entity));
        endTransaction(em);
    }

    public abstract void execute();
}
